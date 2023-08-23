package com.example.song_management.service;

import com.example.song_management.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> searchBySongName(Pageable pageable, String searchSongName);
}
