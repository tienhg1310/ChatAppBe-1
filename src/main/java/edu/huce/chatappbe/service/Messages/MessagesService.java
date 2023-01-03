package edu.huce.chatappbe.service.Messages;


import com.fasterxml.jackson.databind.util.BeanUtil;

import edu.huce.chatappbe.domain.Messages.GroupMessage;
import edu.huce.chatappbe.domain.Messages.Message;
import edu.huce.chatappbe.dto.messages.MessageDto;
import edu.huce.chatappbe.dto.messages.MessageGroupDto;
import edu.huce.chatappbe.dto.messages.MessageResponseDto;

import edu.huce.chatappbe.repository.MessageGroupRepository;
import edu.huce.chatappbe.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MessagesService {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private MessageGroupRepository messageGroupRepository;


    public void sendMessage(String to, MessageDto message) {
        Message record = new Message();
        record.setMessageFrom(message.getFromLogin());
        record.setMessageTo(Integer.parseInt(to));
        record.setMessageText(message.getMessage());

        Message res = messageRepository.save(record);

        simpMessagingTemplate.convertAndSend("/topic/messages/" + to, res);
        simpMessagingTemplate.convertAndSend("/topic/messages/" + message.getFromLogin(), res);
    }

    public List<Message> getListMessage(@PathVariable("from") Integer from, @PathVariable("to") Integer to) {
        return messageRepository.findListFromTo(from, to);

//        return jdbcTemplate.queryForList("select * from messages where (message_from=? and message_to=?) " + "or (message_to=? and message_from=?) order by created_datetime asc", from, to, from, to);
    }

//    public List<Map<String, Object>> getListMessageGroups(@PathVariable("groupid") Integer groupid) {
//        return jdbcTemplate.queryForList("select gm.*,us.name as name from group_messages gm " + "join users us on us.id=gm.user_id " + "where gm.group_id=? order by created_datetime asc", groupid);
//    }
    public List<GroupMessage> getListMessageGroups(@PathVariable("groupid") Integer groupid){

        return messageGroupRepository.findByGroup_idOrderByCreatedDatetimeAsc(groupid);
    }

    public void sendMessageGroup(Integer to, MessageGroupDto message) {
        GroupMessage record = new GroupMessage();
        record.setUser_id(message.getFromLogin());
        record.setGroup_id(to);
        record.setMessages(message.getMessage());

        GroupMessage res = messageGroupRepository.save(record);

//        jdbcTemplate.update("INSERT INTO `group_messages`(`group_id`, `user_id`, `messages`, `created_datetime`) " + "VALUES (?,?,?,current_timestamp )", to, message.getFromLogin(), message.getMessage());
//        message.setGroupId(to);
        simpMessagingTemplate.convertAndSend("/topic/messages/group/" + to, res);
        simpMessagingTemplate.convertAndSend("/topic/messages/group/" + message.getFromLogin(), res);


    }
}
