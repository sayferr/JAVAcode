package com.studeis.tomcat.social_network.controllers;

import com.studeis.tomcat.social_network.services.BlackListService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blacklist")
public class BlackListController {

    private final BlackListService blacklistService;

    public BlackListController(BlackListService blacklistService) {
        this.blacklistService = blacklistService;
    }

    @PostMapping("/block")
    public void block(@RequestParam Long ownerId, @RequestParam Long blockedId) {
        blacklistService.block(ownerId, blockedId);
    }

    @DeleteMapping("/unblock")
    public void unblock(@RequestParam Long ownerId, @RequestParam Long blockedId) {
        blacklistService.unblock(ownerId, blockedId);
    }
}
