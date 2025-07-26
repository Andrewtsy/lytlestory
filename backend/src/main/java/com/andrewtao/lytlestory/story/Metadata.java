package com.andrewtao.lytlestory.story;

import java.util.UUID;

public class Metadata {
    private UUID id;
    private String title;
    private String author;
    private String genre;
    private String file_name;

    // Constructors
    public Metadata() {
    }

    public Metadata(UUID id, String title,
            String author, String genre, String file_name) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.file_name = file_name;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}
