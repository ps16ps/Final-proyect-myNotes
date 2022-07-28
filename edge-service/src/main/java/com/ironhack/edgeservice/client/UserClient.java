package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/users")
    public User findByUsername(@RequestParam String username);
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id);

    @PostMapping("/users")
    public User saveUser(@RequestBody User user);

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id);

    @GetMapping("/login")
    public User login(@AuthenticationPrincipal User user);
}