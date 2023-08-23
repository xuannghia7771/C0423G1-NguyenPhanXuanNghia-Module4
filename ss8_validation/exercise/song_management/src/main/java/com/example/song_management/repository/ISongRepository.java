package com.example.song_management.repository;

import com.example.song_management.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> findSongBySongNameContaining(Pageable pageable, String searchSongName);

    @Modifying
    @Transactional
    @Query(value = "insert into song(song_artist, song_name, song_type) values (:artist,:name,:type)", nativeQuery = true)
    void saveNewSong(@Param("name") String songName, @Param("artist") String artist, @Param("type") String type);

    @Modifying
    @Transactional
    @Query(value = "select * from song where song_id = :id", nativeQuery = true)
    Song findSongById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update from song set song_artist = :artist, song_name = :name, song_type = :type where song_id = :id", nativeQuery = true)
    void updateSong(@Param("id") int id, @Param("name") String songName, @Param("artist") String artist, @Param("type") String type);
}
