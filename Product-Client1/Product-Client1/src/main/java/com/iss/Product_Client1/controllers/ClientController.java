package com.iss.Product_Client1.controllers;

import com.iss.Product_Client1.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ai")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("")
    public String home()
    {
        return "aihome";
    }

    @PostMapping("/chat")
    public String chat(@RequestParam String prompt, Model model)
    {
        String conversationId = "admin-123";

        String response = clientService.chat(prompt, conversationId);

        model.addAttribute("prompt", prompt);
        model.addAttribute("response", response);

        return "aihome";
    }
}

//this works only for the single user where it stores the history for the same user when we run the application using th conversationid=admin-123 and to store the history for different users then need to create session id's