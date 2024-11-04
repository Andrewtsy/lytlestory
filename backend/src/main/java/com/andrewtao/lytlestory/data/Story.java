package com.andrewtao.lytlestory.data;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;
    private String file_path;

    // @Column(name = "created_at", nullable = false, updatable = false)
    // private LocalDateTime createdAt;

    public Story() {
    }

    public Story(String title, String author, String genre, String file_path) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.file_path = file_path;
    }

    // @PrePersist
    // protected void onCreate() {
    // createdAt = LocalDateTime.now();
    // }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getFilePath() {
        return file_path;
    }
}
