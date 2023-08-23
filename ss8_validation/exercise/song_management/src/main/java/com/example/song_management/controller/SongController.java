package com.example.song_management.controller;

import com.example.song_management.dto.SongDto;
import com.example.song_management.model.Song;
import com.example.song_management.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String ShowList(Model model,
                           @RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String searchSongName){
        Pageable pageable = PageRequest.of(page, 4);
        Page<Song> songPage = songService.searchBySongName(pageable, searchSongName);
        model.addAttribute("songPage", songPage);
        model.addAttribute("searchSongName", searchSongName);
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }
    @PostMapping("/save")
    public String create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.addNewSong(song);
        redirectAttributes.addFlashAttribute("message", "CREATE SUCCESSFULLY!");
        return "redirect:/song";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findSongById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirect) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.updateSong(song);
        redirect.addFlashAttribute("message", "EDIT SUCCESSFULLY!");
        return "redirect:/song";
    }
}
