package com.springboottesting.repository;

import com.springboottesting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Integer> {
    List<User> findByAddress(String address);
}
