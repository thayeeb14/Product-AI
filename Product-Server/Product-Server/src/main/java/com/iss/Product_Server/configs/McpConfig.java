package com.iss.Product_Server.configs;

import com.iss.Product_Server.services.ToolsService;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider tools(ToolsService toolsService) {

        return MethodToolCallbackProvider.builder()
                .toolObjects(toolsService)
                .build();
    }
}