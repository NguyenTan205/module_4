package com.codegym.springuploadsong.service;

import com.codegym.springuploadsong.model.Song;

import java.util.List;

public interface SongService {
    List<Song> findAll();

    Song findById(int id);

    void save(Song song);
}
