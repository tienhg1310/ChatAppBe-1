package edu.huce.chatappbe.repository;

import edu.huce.chatappbe.domain.Messages.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageGroupRepository extends JpaRepository<GroupMessage, Integer> {
    @Query("select g from GroupMessage g where g.group_id = ?1 order by g.createdDatetime")
    List<GroupMessage> findByGroup_idOrderByCreatedDatetimeAsc(Integer group_id);

}