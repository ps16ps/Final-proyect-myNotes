package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("note-service")
public interface NoteClient {

    @GetMapping("/notes")
    public List<Note> findAll();


    @GetMapping("/notes/{id}")
    public Note findById(@PathVariable Long id);


    @PostMapping("/notes")
    public Note saveNote(@RequestBody Note note);

    @DeleteMapping("/notes/{id}")
    public void delete(@PathVariable Long id);

    @PutMapping("/notes/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid Note note);

    @GetMapping("/notes/users/{userId}")
    List<Note> findByUserId(@PathVariable Long userId);
}
