package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.model.User;

public interface EdgeService {
    //void addNoteToUser(Long userId, Long noteId);
    UserDTO findUserWithNotes(Long userId);
    UserDTO userToDTO(User user);
}
