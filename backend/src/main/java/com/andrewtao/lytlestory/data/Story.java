package com.andrewtao.lytlestory.data;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    private String id;
    private String title;
    private String author;

    public Story(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
