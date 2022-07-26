package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.model.Note;
import com.ironhack.edgeservice.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EdgeController {
    List<Note> findAllNotes();

    Note findNotesById(Long id);
    Note saveNote(Note note);

    void update(Long id, Note note);

    void deleteNote(Long id);


    User saveUser(User note);

    void deleteUser(Long id);
}
