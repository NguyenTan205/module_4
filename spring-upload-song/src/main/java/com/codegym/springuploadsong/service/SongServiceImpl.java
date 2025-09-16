package com.codegym.springuploadsong.service;

import com.codegym.springuploadsong.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongServiceImpl implements SongService {
    private final List<Song> songList;

    public SongServiceImpl() {
        songList = new ArrayList<>();
    }

    @Override
    public List<Song> findAll() {
        return songList;
    }

    @Override
    public Song findById(int id) {
        return songList.get(id);
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }
}
