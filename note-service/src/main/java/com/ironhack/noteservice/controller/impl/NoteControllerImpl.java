package com.ironhack.noteservice.controller.impl;

import com.ironhack.noteservice.controller.interfaces.NoteController;
import com.ironhack.noteservice.model.Note;
import com.ironhack.noteservice.repository.NoteRepository;
import com.ironhack.noteservice.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NoteControllerImpl implements NoteController {
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    NoteService noteService;

    @GetMapping("/notes")
    @ResponseStatus(HttpStatus.OK)
    public List<Note> findAll() {
        List<Note> noteList = noteRepository.findAll();
        return noteList;
    }

    @GetMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Note findById(@PathVariable Long id) {
        return noteService.findById(id);
    }

    @PostMapping("/notes")
    @ResponseStatus (HttpStatus.CREATED)
    public Note saveNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @DeleteMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        noteService.delete(id);
    }

    @PutMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @Valid Note note) {
        noteService.renovate(id, note);
    }

    @GetMapping("/notes/users/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Note> findByUserId(@PathVariable Long userId) {
        return noteService.findByUserId(userId);
    }
}


