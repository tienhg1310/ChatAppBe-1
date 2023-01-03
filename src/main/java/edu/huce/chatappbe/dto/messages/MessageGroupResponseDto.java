package edu.huce.chatappbe.dto.messages;

import edu.huce.chatappbe.domain.Messages.GroupMessage;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link GroupMessage} entity
 */
@Data
public class MessageGroupResponseDto implements Serializable {
    private final Integer id;
    private final Integer group_id;
    private final Integer user_id;
    @Size(max = 255)
    private final String messages;
    private final Instant createdDatetime;
}