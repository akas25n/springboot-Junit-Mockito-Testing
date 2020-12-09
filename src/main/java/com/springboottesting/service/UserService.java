package com.springboottesting.service;

import com.springboottesting.model.User;
import com.springboottesting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> getUserByAddress(String address){
        return userRepository.findByAddress(address);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
