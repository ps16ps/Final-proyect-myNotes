package com.ironhack.userservice.service;

import com.ironhack.userservice.models.User;

public interface UserService {
    User findById(Long id);
    void delete(Long id);
}
