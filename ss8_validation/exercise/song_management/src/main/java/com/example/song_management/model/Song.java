package com.example.song_management.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private int id;
    @Column(name = "song_name")
    private String songName;
    @Column(name = "song_artist")
    private String artist;
    @Column(name = "song_type")
    private String type;

    public Song() {

    }

    public Song(int id, String songName, String artist, String type) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
