package com.andrewtao.lytlestory.data;

import jakarta.persistence.*;
import jakarta.persistence.Id;
// import org.springframework.data.annotation.Id;;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    public Story() {
    }

    public Story(String title, String author) {
        this.title = title;
        this.author = author;
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
}
