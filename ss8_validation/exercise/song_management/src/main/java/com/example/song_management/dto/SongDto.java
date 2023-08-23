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
        SongDto songDto = (SongDto) target;
        if (songDto.getSongName().equals("")){
            errors.rejectValue("songName",null,"Not Empty");
        } else if (!songDto.getSongName().matches("^[a-zA-Z0-9]{1,800}$")) {
            errors.rejectValue("songName",null,"Song name not over 800 char and not contain (@ ; , . = - + , ….)");
        }
        if (songDto.getArtist().equals("")){
            errors.rejectValue("artist",null,"Not Empty");
        } else if (!songDto.getSongName().matches("^[a-zA-Z0-9]{1,300}$")) {
            errors.rejectValue("artist",null,"Artist name not over 300 char and not contain (@ ; , . = - + , ….)");
        }
        if (songDto.getType().equals("")){
            errors.rejectValue("type",null,"Not Empty");
        } else if (!songDto.getType().matches("^[a-zA-Z0-9,]{1,1000}$")) {
            errors.rejectValue("type",null,"Type name not over 1000 char and not contain only ','");
        }
    }
}
