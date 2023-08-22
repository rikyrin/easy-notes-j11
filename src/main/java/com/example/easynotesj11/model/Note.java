package com.example.easynotesj11.model;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Data
public class Note {
    private String title;
    private String content;
    private LocalDate date;
    private long id;

    public Note() {
        this.date = LocalDate.now();
    }

}
