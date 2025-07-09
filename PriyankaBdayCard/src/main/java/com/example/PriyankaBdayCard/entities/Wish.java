package com.example.PriyankaBdayCard.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table
public class Wish {
    @SequenceGenerator(
            name = "card_seq",
            sequenceName = "card_sequence",
            allocationSize = 1 // No gaps
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "card_seq"

    )
    @Id // primary key
    private int id;
    @Column (nullable = false)
    private String name;
    @Column(nullable = false)
    private String message;
    @CreationTimestamp // from hibernate
    private LocalDateTime dateCreated;

    public Wish() {
        System.out.println("Wish object created");
    }

    public Wish(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public Wish(int id, String name, String message, LocalDateTime dateCreated) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
