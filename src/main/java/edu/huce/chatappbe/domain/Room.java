package edu.huce.chatappbe.domain;

import edu.huce.chatappbe.domain.Users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;


    @Column(name = "createddate", nullable = false)
    private String createddate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "createdby", nullable = false)
    private User creator;

}
