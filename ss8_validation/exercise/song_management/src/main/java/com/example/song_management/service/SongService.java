package com.example.song_management.service;

import com.example.song_management.model.Song;
import com.example.song_management.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> searchBySongName(Pageable pageable, String searchSongName) {
        return songRepository.findSongBySongNameContaining(pageable, searchSongName);
    }

    @Override
    public void addNewSong(Song song) {
        songRepository.saveNewSong(song.getSongName(), song.getArtist(), song.getType());
    }

    @Override
    public Song findSongById(int id) {
        return songRepository.findSongById(id);
    }

    @Override
    public void updateSong(Song song) {
        songRepository.updateSong(song.getId(), song.getSongName(), song.getArtist(), song.getType());
    }

}
