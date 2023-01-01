package edu.huce.chatappbe.repository;

import edu.huce.chatappbe.domain.Messages.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

//    @Query("select m from Message m where (m.messageFrom=?1 and m.messageTo=?2) or (m.messageTo=? and message_from=?) order by created_datetime asc")
//    List<Message> findByMessageFromAndMessageTo(Integer messageFrom, Integer messageTo);

    @Query("select m from Message m where (m.messageFrom = ?1 and m.messageTo = ?2) or (m.messageFrom = ?2 and m.messageTo = ?1) order by m.createdDatetime asc ")
    List<Message> findListFromTo(Integer messageFrom, Integer messageTo);






}