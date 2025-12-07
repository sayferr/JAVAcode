package com.studeis.tomcat.social_network.controllers;

import com.studeis.tomcat.social_network.dto.like.LikeResponseDTO;
import com.studeis.tomcat.social_network.dto.post.PostRequestDTO;
import com.studeis.tomcat.social_network.dto.post.PostResponseDTO;
import com.studeis.tomcat.social_network.services.LikeService;
import com.studeis.tomcat.social_network.services.PostService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public PostResponseDTO createPost(@RequestBody PostRequestDTO dto) {
        return postService.createPost(dto);
    }

    @PutMapping("/{id}")
    public PostResponseDTO updatePost(@PathVariable Long id, @RequestBody PostRequestDTO dto) {
        return postService.updatePost(id, dto);
    }

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