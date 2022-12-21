package edu.huce.chatappbe.service.Messages;

import edu.huce.chatappbe.domain.Messages.Messages;
import edu.huce.chatappbe.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesService {
    @Autowired
    MessagesRepository messagesRepository;

    public Messages save(Messages entity) {
        return messagesRepository.save(entity);
    }
}
