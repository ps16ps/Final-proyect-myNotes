package com.ironhack.edgeservice.model;

public class Note {

    private long id;
    private String name;
    private String content;

    private Long userId;

    public Note() {
    }

    public Note(String name, String content, Long userId) {
        this.name = name;
        this.content = content;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
