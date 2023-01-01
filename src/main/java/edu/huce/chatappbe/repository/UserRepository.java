package edu.huce.chatappbe.repository;

import edu.huce.chatappbe.domain.Users.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    boolean existsByName(String name);
}