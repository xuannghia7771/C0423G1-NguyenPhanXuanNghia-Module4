package com.example.song_management.repository;

import com.example.song_management.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> findSongBySongNameContaining(Pageable pageable, String searchSongName);
}
