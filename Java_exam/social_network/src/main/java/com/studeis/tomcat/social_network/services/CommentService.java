package com.studeis.tomcat.social_network.services;

import com.studeis.tomcat.social_network.dto.comment.CommentRequestDTO;
import com.studeis.tomcat.social_network.dto.comment.CommentResponseDTO;
import com.studeis.tomcat.social_network.models.Comment;
import com.studeis.tomcat.social_network.models.Post;
import com.studeis.tomcat.social_network.repositories.CommentRepository;
import com.studeis.tomcat.social_network.repositories.PostRepository;
import com.studeis.tomcat.social_network.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository,
                          PostRepository postRepository,
                          UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<CommentResponseDTO> getAllComments() {
        return commentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public List<CommentResponseDTO> getCommentsByPostId(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        return commentRepository.findByPost(post)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public CommentResponseDTO getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return mapToDTO(comment);
    }

    public CommentResponseDTO createComment(CommentRequestDTO dto) {

        var post = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        var user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setPost(post);
        comment.setUser(user);

        return mapToDTO(commentRepository.save(comment));
    }

    public CommentResponseDTO updateComment(Long id, CommentRequestDTO dto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.setContent(dto.getContent());

        return mapToDTO(commentRepository.save(comment));
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    private CommentResponseDTO mapToDTO(Comment comment) {
        CommentResponseDTO dto = new CommentResponseDTO();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt().toString());
        dto.setUserId(comment.getUser().getId());
        dto.setPostId(comment.getPost().getId());
        dto.setUsername(comment.getUser().getUsername());


        return dto;
    }
}