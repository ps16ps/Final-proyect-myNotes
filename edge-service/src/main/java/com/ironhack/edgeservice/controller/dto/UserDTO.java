package com.ironhack.edgeservice.controller.dto;

import com.ironhack.edgeservice.model.Note;

import java.util.List;

public class UserDTO {

    private long id;
    private String name;

    private String username;
    private String email;
    private String password;
    private List<Note> noteList;

    public UserDTO() {
    }

    public UserDTO(String name, String username, String email, String password, List<Note> noteList) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.noteList = noteList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

}
