package com.studeis.tomcat.social_network.services;

import com.studeis.tomcat.social_network.dto.follower.FollowResponseDTO;
import com.studeis.tomcat.social_network.models.Follow;
import com.studeis.tomcat.social_network.repositories.FollowRepository;
import com.studeis.tomcat.social_network.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public FollowService(FollowRepository followRepository, UserRepository userRepository) {
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    public FollowResponseDTO follow(Long followerId, Long followingId) {

        if (followerId.equals(followingId)) {
            throw new RuntimeException("Cannot follow yourself");
        }

        followRepository.findByFollowerIdAndFollowingId(followerId, followingId)
                .ifPresent(f -> { throw new RuntimeException("Already following"); });

        var follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));
        var following = userRepository.findById(followingId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);

        followRepository.save(follow);

        return new FollowResponseDTO(follow.getId(), followerId, followingId, follow.getCreatedAt());
    }

    public void unfollow(Long followerId, Long followingId) {
        Follow f = followRepository.findByFollowerIdAndFollowingId(followerId, followingId)
                .orElseThrow(() -> new RuntimeException("Not following"));
        followRepository.delete(f);
    }

    public List<FollowResponseDTO> getFollowers(Long userId) {
        return followRepository.findAllByFollowingId(userId)
                .stream()
                .map(f -> new FollowResponseDTO(
                        f.getId(),
                        f.getFollower().getId(),
                        f.getFollower().getUsername(),
                        f.getFollower().getImageUrl(),
                        f.getCreatedAt()
                ))
                .toList();
    }

    public List<FollowResponseDTO> getFollowing(Long userId) {
        return followRepository.findAllByFollowerId(userId)
                .stream()
                .map(f -> new FollowResponseDTO(
                        f.getId(),
                        f.getFollowing().getId(),
                        f.getFollowing().getUsername(),
                        f.getFollowing().getImageUrl(),
                        f.getCreatedAt()
                ))
                .toList();
    }
}