package edu.huce.chatappbe.dto.auth;


import edu.huce.chatappbe.domain.Users.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class AuthRegisterDto implements Serializable {
    private  Integer id;

    @NotEmpty(message = "Name is not valid")
    private  String name;


    @NotEmpty(message = "Password is not valid")
    private String password;


}