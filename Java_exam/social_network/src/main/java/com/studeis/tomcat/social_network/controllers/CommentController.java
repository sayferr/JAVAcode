package com.studeis.tomcat.social_network.controllers;

import com.studeis.tomcat.social_network.dto.comment.CommentRequestDTO;
import com.studeis.tomcat.social_network.dto.comment.CommentResponseDTO;
import com.studeis.tomcat.social_network.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentResponseDTO> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/post/{postId}")
    public List<CommentResponseDTO> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/{id}")
    public CommentResponseDTO getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping
    public CommentResponseDTO createComment(@RequestBody CommentRequestDTO dto) {
        return commentService.createComment(dto);
    }

    @PutMapping("/{id}")
    public CommentResponseDTO updateComment(@PathVariable Long id, @RequestBody CommentRequestDTO dto) {
        return commentService.updateComment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}