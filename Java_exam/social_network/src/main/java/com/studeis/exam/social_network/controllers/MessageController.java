package com.studeis.tomcat.social_network.controllers;

import com.studeis.tomcat.social_network.dto.message.MessageRequestDTO;
import com.studeis.tomcat.social_network.dto.message.MessageResponseDTO;
import com.studeis.tomcat.social_network.services.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public MessageResponseDTO sendMessage(@RequestBody MessageRequestDTO dto) {
        return messageService.sendMessage(dto);
    }

    @GetMapping("/dialog")
    public List<MessageResponseDTO> getDialog(@RequestParam Long user1, @RequestParam Long user2) {
        return messageService.getDialog(user1, user2);
    }
}