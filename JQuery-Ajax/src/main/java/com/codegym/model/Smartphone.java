package com.codegym.model;

import jakarta.persistence.*;

@Entity
@Table (name = "smartphone")
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producer;
    private String model;
    private double price;

    public Smartphone() {
    }

    public Smartphone(Long id, String producer, String model, double price) {
        this.setId(id);
        this.setProducer(producer);
        this.setModel(model);
        this.setPrice(price);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
