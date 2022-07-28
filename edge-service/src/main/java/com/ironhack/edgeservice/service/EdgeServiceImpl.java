package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.NoteClient;
import com.ironhack.edgeservice.client.UserClient;
import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.model.Note;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.service.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EdgeServiceImpl implements EdgeService {

    @Autowired
    NoteClient noteClient;
    @Autowired
    UserClient userClient;
    public UserDTO findUserWithNotes(Long userId){
       User user = userClient.findById(userId);
       List<Note> noteList = noteClient.findByUserId(userId);

       UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(null);
        userDTO.setNoteList(noteList);

        return userDTO;
    }

    public UserDTO userToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
