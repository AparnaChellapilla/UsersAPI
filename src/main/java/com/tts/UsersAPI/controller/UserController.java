package com.tts.UsersAPI.controller;

import com.tts.UsersAPI.model.User;
import com.tts.UsersAPI.repository.UserRepository;
import com.tts.UsersAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GetMapping("/users")
//    public List<User> getUsers(){
//        return (List<User>) userRepository.findAll();
//    }


    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable(value="id") Long id) {
        return userRepository.findById(id);
    }

    @PutMapping("/users/{id}")
    public void createUser(@PathVariable Long id, @RequestBody User user){
        userRepository.save(user);
    }


//
//    @GetMapping("/users/state")
//    public List<User> getUsers(@RequestParam(value="state", required=false) String state){
//        if (state != null) {
//            return (List<User>) userRepository.findByState();
//        }
//        return (List<User>) userRepository.findAll();
//    }


    @DeleteMapping("/users/{id}")
    public void createUser(@PathVariable(value="id") Long id){
        userRepository.deleteById(id);
    }

    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(value="state", required=false) String state) {
        if (state != null) {
            return (List<User>) userRepository.findByState(state);
        }
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
