package edu.huce.chatappbe.controller.auth;


import edu.huce.chatappbe.config.jwt.JwtTokenProvider;
import edu.huce.chatappbe.domain.Users.CustomUserDetails;
import edu.huce.chatappbe.domain.Users.User;
import edu.huce.chatappbe.dto.auth.LoginRequest;
import edu.huce.chatappbe.dto.auth.LoginResponse;
import edu.huce.chatappbe.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth/login")
@CrossOrigin(origins = "*")
public class AuthLoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());

        User user = userRepository.findByName(loginRequest.getUsername());


        return new LoginResponse(jwt, user.getId());
    }


}
