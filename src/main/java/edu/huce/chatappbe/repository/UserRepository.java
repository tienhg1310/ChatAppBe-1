package edu.huce.chatappbe.repository;

import edu.huce.chatappbe.domain.Users.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    public boolean existsByEmail(String email);

    public boolean existsByUsername(String username);


}