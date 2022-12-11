package edu.huce.chatappbe.dto.auth;

import edu.huce.chatappbe.domain.Users.UserStatus;
import edu.huce.chatappbe.domain.Users.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class AuthRegisterDto implements Serializable {
    private  Long id;
    @NotEmpty(message = "Name is not valid")
    private  String name;
    @NotEmpty(message = "User name is not valid")
    private  String username;
    @NotEmpty(message = "Email is not valid")
    private  String email;
    @NotEmpty(message = "Phone number is not valid")
    private String phonenumber;
    @NotEmpty(message = "Password is not valid")
    private String password;

    private  UserStatus status;
}