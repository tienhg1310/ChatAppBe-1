package edu.huce.chatappbe.domain.Messages;

import edu.huce.chatappbe.domain.Users.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sender", nullable = false)
    private User sender;

    public Messages(Long id, String text, User sender, User to) {
        this.id = id;
        this.text = text;
        this.sender = sender;
        this.to = to;
    }

    @ManyToOne
    @JoinColumn(name = "to_id")
    private User to;

    @Column(name = "send_date")
    @CreationTimestamp
    private LocalDateTime sendDate;
}