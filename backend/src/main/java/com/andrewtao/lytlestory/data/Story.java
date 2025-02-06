package com.andrewtao.lytlestory.data;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.nio.file.*;
import java.io.IOException;
import java.net.URL;

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

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;

    private static final URL contentURL = Story.class.getClassLoader().getResource("static/uploads/text_contents");
    private static final String contentFolder = Paths.get(contentURL.getPath()).toAbsolutePath().toString();

    public Story() {
    }

    public Story(String title, String author, String genre, String file_path) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.file_path = file_path;
    }

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }

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

    private String getFilePath() {
        return file_path;
    }

    public String getContent() {
        String file_name = getFilePath();
        Path file_path = Paths.get(contentFolder, file_name);

        try {
            String content = Files.readString(file_path);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error Retreiving content";
        }
    }
}
