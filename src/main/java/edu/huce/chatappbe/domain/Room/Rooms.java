package edu.huce.chatappbe.domain.Room;

import edu.huce.chatappbe.domain.Users.User;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "type", nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "creator")
    private User user;


    @Column(name = "created_date", nullable = false)
    private String createdDate;

}