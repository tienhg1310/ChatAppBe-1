package edu.huce.chatappbe.repository;

import edu.huce.chatappbe.domain.Messages.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {
}