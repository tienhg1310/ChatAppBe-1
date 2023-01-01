package edu.huce.chatappbe.domain.Messages;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "message_text")
    private String messageText;

    @Column(name = "message_from")
    private Integer messageFrom;

    @Column(name = "message_to")
    private Integer messageTo;

    @Column(name = "created_datetime")
    @CreationTimestamp()
    private Instant createdDatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(Integer messageFrom) {
        this.messageFrom = messageFrom;
    }

    public Integer getMessageTo() {
        return messageTo;
    }

    public void setMessageTo(Integer messageTo) {
        this.messageTo = messageTo;
    }

    public Instant getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Instant createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

}