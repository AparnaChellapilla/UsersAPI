package com.tts.UsersAPI.service;

import com.tts.UsersAPI.model.User;
import com.tts.UsersAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {return (List<User>) userRepository.findAll();}
    public void save(User user){
        userRepository.save(user);
    }
    public List<User> findByState(String state) {

        return userRepository.findByState(state);}
}


