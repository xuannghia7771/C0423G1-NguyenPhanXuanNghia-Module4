package com.example.song_management.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private String songName;

    private String artist;

    private String type;

    public SongDto() {

    }

    public SongDto(String songName, String artist, String type) {
        this.songName = songName;
        this.artist = artist;
        this.type = type;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
