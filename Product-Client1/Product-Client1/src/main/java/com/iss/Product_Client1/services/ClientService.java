package com.iss.Product_Client1.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Service
public class ClientService {

    ChatClient chatClient;
    ToolCallbackProvider mcpToolProvider;
    ChatMemory chatMemory;

    public ClientService(ChatClient.Builder chatClientBuilder, ToolCallbackProvider mcpToolProvider)
    {
        chatMemory = MessageWindowChatMemory.builder()
                .maxMessages(50)
                .build();

        chatClient = chatClientBuilder.defaultSystem("""
                You are a shopping cart assistant.
            
                Use the getProducts or getProduct tools whenever product details are required.
            
                Use the addToCart tool to add products to the shopping cart.
            
                Use the getCart tool to retrieve cart details and calculate the total price.
            
                Display all prices in INR (₹).
            
                Always verify product availability before adding products to the cart.
            
                Never assume product prices or availability.
                Use the actual product details returned by the tools.
            
                Provide a clear summary containing:
                - Product ID
                - Product name
                - Unit price
                - Quantity
                - Line total
                - Total product count
                - Total quantity
                - Grand total
                """)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();

        this.mcpToolProvider = mcpToolProvider;
    }

    public String chat(String prompt, String conversationId) {

        ToolCallback[] callbacks = mcpToolProvider.getToolCallbacks();

        System.out.println("Available MCP Tools:");
        for (ToolCallback callback : callbacks) {
            System.out.println(callback.getToolDefinition());
        }

        String progressToken = "token-" + new Random().nextInt();

        return chatClient.prompt()
                .user(prompt)
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, conversationId))
                .toolContext(Map.of("progressToken", progressToken))
                .tools(mcpToolProvider)
                .call()
                .content();
    }
}
