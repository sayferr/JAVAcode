package com.studeis.tomcat.social_network.services;


import com.studeis.tomcat.social_network.dto.message.MessageRequestDTO;
import com.studeis.tomcat.social_network.dto.message.MessageResponseDTO;
import com.studeis.tomcat.social_network.models.Message;
import com.studeis.tomcat.social_network.models.User;
import com.studeis.tomcat.social_network.repositories.MessageRepository;
import com.studeis.tomcat.social_network.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final BlackListService blackListService;

    public MessageService(MessageRepository messageRepository,
                          UserRepository userRepository,
                          BlackListService blackListService){

        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.blackListService = blackListService;
    }

    public MessageResponseDTO sendMessage(MessageRequestDTO dto) {

        if (blackListService.isBlocked(dto.getReceiverId(), dto.getSenderId())) {
            throw new RuntimeException("You are blocked by this user");
        }

        User sender = userRepository.findById(dto.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        User receiver = userRepository.findById(dto.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(dto.getContent());
        message.setCreatedAt(LocalDateTime.now());

        messageRepository.save(message);

        return toResponseDTO(message);
    }

    public List<MessageResponseDTO> getDialog(Long user1, Long user2) {
        List<Message> m1 = messageRepository.findBySenderIdAndReceiverIdOrderById(user1, user2);
        List<Message> m2 = messageRepository.findBySenderIdAndReceiverIdOrderById(user2, user1);

        return List.of(m1, m2)
                .stream()
                .flatMap(List::stream)
                .sorted((a, b) -> a.getId().compareTo(b.getId()))
                .map(this::toResponseDTO)
                .toList();
    }


    private MessageResponseDTO toResponseDTO(Message message) {
        MessageResponseDTO dto = new MessageResponseDTO();
        dto.setId(message.getId());
        dto.setSenderId(message.getSender().getId());
        dto.setReceiverId(message.getReceiver().getId());
        dto.setContent(message.getContent());
        dto.setCreatedAt(message.getCreatedAt().toString());
        return dto;
    }
}
