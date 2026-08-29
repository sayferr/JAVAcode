package com.studeis.tomcat.social_network.services;

import com.studeis.tomcat.social_network.dto.like.LikeResponseDTO;
import com.studeis.tomcat.social_network.models.Like;
import com.studeis.tomcat.social_network.repositories.LikeRepository;
import com.studeis.tomcat.social_network.repositories.PostRepository;
import com.studeis.tomcat.social_network.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    private LikeRepository likeRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;

    public LikeService(LikeRepository likeRepository, PostRepository postRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public LikeResponseDTO addLike(Long postId, Long userId) {
        if (likeRepository.existsByUserIdAndPostId(userId, postId)) {
            throw new RuntimeException("User already liked post");
        }
        Like like = new Like();
        like.setUser(userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
        like.setPost(postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found")));

        likeRepository.save(like);

        return new LikeResponseDTO(
                like.getId(),
                userId,
                postId,
                like.getCreatedAt()
        );
    }

    public long getLikesCount(Long postId) {
        return likeRepository.countByPostId(postId);
    }

    public void removeLike(Long postId, Long userId) {
        if (!likeRepository.existsByUserIdAndPostId(userId, postId)) {
            throw new RuntimeException("User didn't like this post");
        }
        likeRepository.deleteByUserIdAndPostId(userId, postId);
    }

    public List<LikeResponseDTO> getPostLikes(Long postId) {
        return likeRepository.findByPostId(postId).stream()
                .map(like -> new LikeResponseDTO(
                        like.getId(),
                        like.getUser().getId(),
                        like.getPost().getId(),
                        like.getCreatedAt()
                ))
                .toList();
    }
}