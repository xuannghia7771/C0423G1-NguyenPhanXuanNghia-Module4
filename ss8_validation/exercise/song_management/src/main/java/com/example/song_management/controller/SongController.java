package com.example.song_management.controller;

import com.example.song_management.model.Song;
import com.example.song_management.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String ShowList(Model model,
                           @RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String searchSongName){
        Pageable pageable = PageRequest.of(page, 2);
        Page<Song> songPage = songService.searchBySongName(pageable, searchSongName);
        model.addAttribute("songPage", songPage);
        model.addAttribute("searchSongName", searchSongName);
        return "list";
    }
}
