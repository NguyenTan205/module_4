package com.codegym.model;

import jakarta.persistence.*;

@Entity
@Table (name = "category")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Category() {
    }

    public Category(Long id, String name) {
        this.setId(id);
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
