package edu.huce.chatappbe;

import edu.huce.chatappbe.domain.Users.User;
import edu.huce.chatappbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import static edu.huce.chatappbe.domain.Users.UserStatus.Visible;


@SpringBootApplication
public class ChatAppBeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ChatAppBeApplication.class, args);
    }


    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Khi chương trình chạy
        // Insert vào csdl một user.
        User user = new User();
        user.setUsername("tien2001");
        user.setPassword(passwordEncoder.encode("tien2001"));
        user.setName("PT");
        user.setEmail("tienhg203@gmail.com");
        user.setPhonenumber("0869318118");
        user.setStatus(Visible);
        userRepository.save(user);
        System.out.println(user);
    }

}
