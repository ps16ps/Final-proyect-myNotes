package com.ironhack.userservice.controller.impl;

import com.ironhack.userservice.controller.interfaces.UserController;
import com.ironhack.userservice.models.User;
import com.ironhack.userservice.repository.UserRepository;
import com.ironhack.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;


    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public User findByUsername(@RequestParam Optional<String> username) {
        if(username.isPresent()){
            return userRepository.findByUsername(username.get());
        }
        return null;
    }

    @PostMapping("/users")
    @ResponseStatus (HttpStatus.CREATED)
    public User saveUser (@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

//    @GetMapping("/login")
//    @ResponseStatus(HttpStatus.OK)
//    public User login(@AuthenticationPrincipal User user) {
//        System.out.println("login hecho !!!!!!!!!!! :)))))");
//        user.setPassword(null);
//        return user;
//    }

}

