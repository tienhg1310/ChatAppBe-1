package edu.huce.chatappbe.domain.participants;

import edu.huce.chatappbe.domain.Room.Rooms;
import edu.huce.chatappbe.domain.Users.User;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "participants")
public class Participants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rooms_id", nullable = false)
    private Rooms rooms;


}