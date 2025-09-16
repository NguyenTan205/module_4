package com.codegym.springuploadsong.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private String name;
    private String artist;
    private String style;
    private MultipartFile song;

    public SongForm() {
    }

    public SongForm(String name, String artist, String style, MultipartFile song) {
        this.setName(name);
        this.setArtist(artist);
        this.setStyle(style);
        this.setSong(song);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public MultipartFile getSong() {
        return song;
    }

    public void setSong(MultipartFile song) {
        this.song = song;
    }
}
