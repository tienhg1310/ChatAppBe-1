package edu.huce.chatappbe.domain.Messages;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "group_messages")
@Getter
@Setter
public class GroupMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "group_id")
    private Integer group_id;

    @Column(name = "user_id")
    private Integer user_id;

    @Size(max = 255)
    @Column(name = "messages")
    private String messages;

    @Column(name = "created_datetime")
    @CreationTimestamp()
    private Instant createdDatetime;



}