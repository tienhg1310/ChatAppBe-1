package edu.huce.chatappbe.controller.auth;


import edu.huce.chatappbe.domain.Users.User;
import edu.huce.chatappbe.dto.auth.AuthRegisterDto;
import edu.huce.chatappbe.repository.UserRepository;
import edu.huce.chatappbe.service.MapValidationErrorService;
import edu.huce.chatappbe.service.Users.UserAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/register")
@CrossOrigin(origins = "*")
public class AuthRegisterController {
    @Autowired
    UserAuthService userAuthService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping()
    public ResponseEntity<?> register(@Valid @RequestBody AuthRegisterDto dto, BindingResult result) {

//        kiểm tra các trường trả về theo không bij thiếu
        ResponseEntity<?> responseEntity = mapValidationErrorService.mapDataValidationField(result);

        if (responseEntity != null){
            return responseEntity;
        }

        if (userRepository.existsByName(dto.getName())) {
            return new ResponseEntity<>("{\"message\": \"Username is already taken!\"}", HttpStatus.BAD_REQUEST);
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
//        lưu dữ diệu
        User user = new User();
        BeanUtils.copyProperties(dto, user);

        user = userRepository.save(user);

        dto.setId(user.getId());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody @Valid LoginDto dto, BindingResult result){
//        ResponseEntity<?> responseEntity = mapValidationErrorService.mapDataValidationField(result);
//        if (responseEntity != null){
//            return responseEntity;
//        }
//
//        if(userRepository.findByUsername(dto.getUsername())){
//            return new ResponseEntity<>("{\"message\": \"Username incorrect!\"}", HttpStatus.BAD_REQUEST);
//        }
//
//
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }
}
