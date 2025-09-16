package com.codegym.springuploadsong.model;

public class Song {
    private String name;
    private String artist;
    private String style;
    private String song;

    public Song() {
    }

    public Song(String name, String artist, String style, String song) {
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

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }


}
