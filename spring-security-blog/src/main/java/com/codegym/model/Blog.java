package com.codegym.model;

import jakarta.persistence.*;

@Entity
@Table (name = "blog")
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String text;
    @Basic(optional = false)
    private String image;
    @Column(columnDefinition = "boolean default false")
    private Boolean active;
    @ManyToOne
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id"
    )
    private Category category;

    public Blog() {
    }

    public Blog(Long id, String title, String text, String image, Boolean active, Category category) {
        this.setId(id);
        this.setTitle(title);
        this.setText(text);
        this.setImage(image);
        this.setActive(active);
        this.setCategory(category);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
