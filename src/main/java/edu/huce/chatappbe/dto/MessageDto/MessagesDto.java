package edu.huce.chatappbe.dto.MessageDto;

import edu.huce.chatappbe.domain.Messages.Messages;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Messages} entity
 */
@Data
public class MessagesDto implements Serializable {
    private  Long id;
    private  String text;
    private  Long sender;
    private  Long to;
}