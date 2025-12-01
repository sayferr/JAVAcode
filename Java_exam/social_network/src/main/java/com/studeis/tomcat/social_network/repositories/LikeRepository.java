package com.studeis.tomcat.social_network.repositories;

import com.studeis.tomcat.social_network.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
   boolean existsByUserIdAndPostId(Long userId, Long postId);
    void deleteByUserIdAndPostId(Long userId, Long postId);
    long countByPostId(Long postId);
    List<Like> findByPostId(Long postId);
}
