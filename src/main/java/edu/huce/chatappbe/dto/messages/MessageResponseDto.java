package edu.huce.chatappbe.dto.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MessageResponseDto {

    private String message;
    private int fromLogin;

    private int to;

    @Override
    public String toString() {
        return "MessageDTO{" + "message='" + message + '\'' + ", fromLogin=" + fromLogin + ", to=" + to + '}';
    }
}
