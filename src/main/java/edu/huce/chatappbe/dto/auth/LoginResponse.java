package edu.huce.chatappbe.dto.auth;


import lombok.Data;

@Data
public class LoginResponse {

    private Integer id;
    private String accessToken;
    private String tokenType = "Bearer";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    public LoginResponse(String accessToken, Integer id) {
        this.id = id;
        this.accessToken = accessToken;
    }
}
