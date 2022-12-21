package edu.huce.chatappbe.domain.Users;


import lombok.*;


import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;
    @Enumerated
    @Column(name = "status")
    private UserStatus status;

    @Column(name = "phone_number")
    private String phonenumber;


}