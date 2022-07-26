package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.controller.dto.UserDTO;

public interface EdgeService {
    //void addNoteToUser(Long userId, Long noteId);
    UserDTO findUserWithNotes(Long userId);
}
