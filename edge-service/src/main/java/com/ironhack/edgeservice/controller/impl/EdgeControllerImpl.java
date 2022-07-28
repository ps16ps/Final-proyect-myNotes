package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.client.NoteClient;
import com.ironhack.edgeservice.client.UserClient;
import com.ironhack.edgeservice.controller.dto.UserDTO;
import com.ironhack.edgeservice.controller.interfaces.EdgeController;
import com.ironhack.edgeservice.model.Note;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.security.CustomUserDetails;
import com.ironhack.edgeservice.service.EdgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@Slf4j
@CrossOrigin("*")
public class EdgeControllerImpl implements EdgeController {

    @Autowired
    NoteClient noteClient;
    @Autowired
    UserClient userClient;
    @Autowired
    EdgeService edgeService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/notes")
    @ResponseStatus(HttpStatus.OK)
    public List<Note> findAllNotes() {
        List<Note> noteList = noteClient.findAll();
        return noteList;
    }

    @GetMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Note findNotesById(@PathVariable Long id) {
        return noteClient.findById(id);
    }

    @PostMapping("/notes")
    @ResponseStatus (HttpStatus.CREATED)
    public Note saveNote(@RequestBody Note note) {
        System.out.println("######################################################################");
        System.out.println("######################################################################");
        System.out.println(note.getContent());
        System.out.println("######################################################################");
        System.out.println("######################################################################");
        return noteClient.saveNote(note);
    }

    @PutMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @Valid Note note) {
        noteClient.update(id, note);

    }
    @DeleteMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable Long id) {
        noteClient.delete(id);
    }


    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findUserByIdWithNotes(@PathVariable Long id) {
        return edgeService.findUserWithNotes(id);
    }

    @PostMapping("/users")
    @ResponseStatus (HttpStatus.CREATED)
    public User saveUser (@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userClient.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userClient.delete(id);
    }
    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO login(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        System.out.println("login hecho !!!!!!!!!!! :)))))");
        customUserDetails.getUser().setPassword(null);
        return edgeService.userToDTO(customUserDetails.getUser());
    }


}
