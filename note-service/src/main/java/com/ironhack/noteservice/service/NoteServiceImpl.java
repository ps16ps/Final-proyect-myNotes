package com.ironhack.noteservice.service;

import com.ironhack.noteservice.model.Note;
import com.ironhack.noteservice.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {


    @Autowired
    private NoteRepository noteRepository;

    public Note findById(Long id) {
        Note note = noteRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + id + " not found"));
        return note;
    }

    public void delete(Long id) {
        Note note = noteRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Lead not found"));
        noteRepository.delete(note);
    }

    public void renovate(Long id, Note note) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (!optionalNote.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found :C");
        }
        note.setId(id);
        noteRepository.save(note);
    }

    public List<Note> findByUserId(Long userId){
        return noteRepository.findByUserId(userId);
    }
}
