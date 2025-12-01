package com.studeis.tomcat.social_network.repositories;

import com.studeis.tomcat.social_network.models.Comment;
import com.studeis.tomcat.social_network.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
