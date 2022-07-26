package com.ironhack.noteservice.service;

import com.ironhack.noteservice.model.Note;

import java.util.List;

public interface NoteService {
    Note findById(Long id);

    void delete(Long id);
    void renovate(Long id, Note note);

    List<Note> findByUserId(Long userId);
}
