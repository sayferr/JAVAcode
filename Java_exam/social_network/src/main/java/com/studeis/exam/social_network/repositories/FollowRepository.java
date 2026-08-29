package com.studeis.tomcat.social_network.repositories;

import com.studeis.tomcat.social_network.models.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFollowerIdAndFollowingId(Long followerId, Long followingId);
    List<Follow> findAllByFollowingId(Long followingId); // на кого
    List<Follow> findAllByFollowerId(Long followerId); // кто
}
