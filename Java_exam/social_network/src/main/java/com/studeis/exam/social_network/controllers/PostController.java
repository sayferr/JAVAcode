package com.studeis.tomcat.social_network.controllers;

import com.studeis.tomcat.social_network.dto.like.LikeResponseDTO;
import com.studeis.tomcat.social_network.dto.post.PostRequestDTO;
import com.studeis.tomcat.social_network.dto.post.PostResponseDTO;
import com.studeis.tomcat.social_network.services.LikeService;
import com.studeis.tomcat.social_network.services.PostService;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final LikeService likeService;
    private final PostService postService;

    public  PostController(PostService postService, LikeService likeService) {
        this.postService = postService;
        this.likeService = likeService;
    }

    // Get
    @GetMapping
    public List<PostResponseDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostResponseDTO getPostById(@PathVariable long id) {
        return  postService.getPostById(id);
    }

    @GetMapping("/user/{userId}")
    public List<PostResponseDTO> getPostsByUser(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }

    @GetMapping("/my")
    public List<PostResponseDTO> getMyPosts(Authentication authentication) {
        String username = authentication != null ? authentication.getName() : null;
        if (username == null) {
            throw new RuntimeException("Unauthorized");
        }
        return postService.getPostsByUsername(username);
    }

    // Post
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public PostResponseDTO createPost(@RequestPart("data") PostRequestDTO dto, @RequestPart(value = "image", required = false) MultipartFile image) {
        return postService.createPost(dto, image);
    }

      @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
      public PostResponseDTO updatePost(
              @PathVariable Long id,
              @RequestPart("data") PostRequestDTO dto,
              @RequestPart(value = "image", required = false) MultipartFile image) {
        return postService.updatePost(id, dto, image);
    }

    // Del
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    // Like cont
    @PostMapping("/{postId}/like")
    public LikeResponseDTO  likePost(@PathVariable Long postId, @RequestParam Long userId) {
        return likeService.addLike(postId, userId);
    }

    @DeleteMapping("/{postId}/like")
    public void unlikePost(@PathVariable Long postId, @RequestParam Long userId) {
        likeService.removeLike(postId, userId);
    }

    @GetMapping("/{postId}/like")
    public List<LikeResponseDTO> getLikes(@PathVariable Long postId) {
        return likeService.getPostLikes(postId);
    }
}