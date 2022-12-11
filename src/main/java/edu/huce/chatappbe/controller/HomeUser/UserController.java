package edu.huce.chatappbe.controller.HomeUser;

import edu.huce.chatappbe.domain.Users.User;
import edu.huce.chatappbe.service.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllUser(){
        List<User> users = userService.findAllUser();
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }
}
