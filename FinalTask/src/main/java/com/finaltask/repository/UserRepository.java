package com.finaltask.repository;

import com.finaltask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // найти пользователя по почте
    boolean existsByEmail(String email); // узнать существует ли пользователь
}