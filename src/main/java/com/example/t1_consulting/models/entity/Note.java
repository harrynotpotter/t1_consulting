package com.example.t1_consulting.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String text;
    private LocalDate date;


    public Note(String name, String text, LocalDate date) {
        this.name = name;
        this.text = text;
        this.date = date;
    }

    public Note(int id, String name, String text, LocalDate date) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.date = date;
    }
}
