package com.studeis.tomcat.social_network.services;

import com.studeis.tomcat.social_network.models.BlackList;
import com.studeis.tomcat.social_network.models.User;
import com.studeis.tomcat.social_network.repositories.BlackListRepository;
import com.studeis.tomcat.social_network.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BlackListService {

    private final BlackListRepository blacklistRepository;
    private final UserRepository userRepository;

    public BlackListService(BlackListRepository blacklistRepository, UserRepository userRepository) {
        this.blacklistRepository = blacklistRepository;
        this.userRepository = userRepository;
    }

    public void block(Long ownerId, Long blockedId) {
        if (exists(ownerId, blockedId)) return;

        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        User blocked = userRepository.findById(blockedId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        BlackList bl = new BlackList();
        bl.setOwner(owner);
        bl.setBlocked(blocked);

        blacklistRepository.save(bl);
    }

    public void unblock(Long ownerId, Long blockedId) {
        blacklistRepository.deleteByOwnerIdAndBlockedId(ownerId, blockedId);
    }

    public boolean exists(Long ownerId, Long blockedId) {
        return blacklistRepository.existsByOwnerIdAndBlockedId(ownerId, blockedId);
    }

    public boolean isBlocked(Long ownerId, Long blockedId) {
        return exists(ownerId, blockedId);
    }
}