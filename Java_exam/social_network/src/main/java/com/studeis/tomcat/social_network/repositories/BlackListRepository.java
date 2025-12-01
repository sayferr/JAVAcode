package com.studeis.tomcat.social_network.repositories;

import com.studeis.tomcat.social_network.models.BlackList;
import com.studeis.tomcat.social_network.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList, Long> {

    boolean existsByOwnerIdAndBlockedId(Long ownerId, Long blockedId);

    void deleteByOwnerIdAndBlockedId(Long ownerId, Long blockedId);
}
