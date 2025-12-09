package com.studeis.tomcat.social_network.services;

import com.studeis.tomcat.social_network.dto.post.PostRequestDTO;
import com.studeis.tomcat.social_network.dto.post.PostResponseDTO;
import com.studeis.tomcat.social_network.dto.user.UserSummaryDTO;
import com.studeis.tomcat.social_network.models.Post;
import com.studeis.tomcat.social_network.models.User;
import com.studeis.tomcat.social_network.repositories.PostRepository;
import com.studeis.tomcat.social_network.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostResponseDTO> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username " + username));

        return postRepository.findAllByUserId(user.getId())
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public PostResponseDTO createPost(PostRequestDTO dto, MultipartFile image) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + dto.getUserId()));

        Post post = new Post();
        post.setContent(dto.getContent());
        post.setImageUrl(dto.getImageUrl());
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());

        if (image != null && !image.isEmpty()) {
            String fileName = saveImage(image);
            post.setImageUrl("/uploads/" + fileName);
        }

        return mapToDTO(postRepository.save(post));
    }
//    public PostResponseDTO updatePost(Long id, PostRequestDTO dto) {
//
//        Post post = postRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Post not found " + id));
//
//        post.setContent(dto.getContent());
//        post.setImageUrl(dto.getImageUrl());
//
//        return mapToDTO(postRepository.save(post));
//    }

    public PostResponseDTO updatePost(Long id, PostRequestDTO dto, MultipartFile image) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found " + id));

        post.setContent(dto.getContent());

        if (image != null && !image.isEmpty()) {
            String fileName = saveImage(image);
            post.setImageUrl("/uploads/" + fileName);
        }

        return mapToDTO(postRepository.save(post));
    }

    private String saveImage(MultipartFile image) {
        try {
            String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
            Path path = Paths.get("uploads/" + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, image.getBytes());
            return fileName;
        } catch (Exception e) {
            throw new RuntimeException("Failed to save image");
        }
    }

    public List<PostResponseDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    public List<PostResponseDTO> getPostsByUserId(Long userId) {
        return postRepository.findAllByUserId(userId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public PostResponseDTO getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post with id " + id + " does not exist"));

        return mapToDTO(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    private PostResponseDTO mapToDTO(Post post) {
        PostResponseDTO dto = new PostResponseDTO();
        dto.setId(post.getId());
        dto.setContent(post.getContent());
        dto.setImageUrl(post.getImageUrl());
        dto.setCreatedAt(post.getCreatedAt().toString());

        UserSummaryDTO userDto = new UserSummaryDTO();
        userDto.setId(post.getUser().getId());
        userDto.setUsername(post.getUser().getUsername());
        userDto.setImageUrl(post.getUser().getImageUrl());
        dto.setUser(userDto);

        int likes = post.getLikes() == null ? 0 : post.getLikes().size();
        dto.setLikesCount(likes);

        return dto;
    }
}