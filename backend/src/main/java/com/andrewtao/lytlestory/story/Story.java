package com.andrewtao.lytlestory.story;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.nio.file.*;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "BINARY(16)")
    @JdbcTypeCode(SqlTypes.BINARY)
    private UUID id;

    private String title;
    private String author;
    private String genre;
    private String file_name;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;

    private static final URL contentURL = Story.class.getClassLoader().getResource("static/uploads/text_contents");
    private static final String contentFolder;
    static {
        if (contentURL != null) {
            contentFolder = Paths.get(contentURL.getPath()).toAbsolutePath().toString();
        } else {
            contentFolder = null;
            System.err.println("Content unable to be found.");
        }
    }

    public Story() {
    }

    public Story(String title, String author, String genre, String file_name) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.file_name = file_name;
    }

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }

    public UUID getId() {
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

    public String getFileName() {
        return file_name;
    }

    public String getContent() {
        String file_name = getFileName() + ".html";
        Path file_path = Paths.get(contentFolder, file_name);

        try {
            String content = Files.readString(file_path);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error Retrieving content";
        }
    }

}
