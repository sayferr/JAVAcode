package com.studeis.tomcat.social_network.repositories;

import com.studeis.tomcat.social_network.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findBySenderIdAndReceiverIdOrderById(Long senderId, Long receiverId);

    List<Message> findBySenderIdOrReceiverIdOrderById(Long senderId, Long receiverId);
}
