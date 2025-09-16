package com.codegym.springuploadsong.controller;

import com.codegym.springuploadsong.model.Song;
import com.codegym.springuploadsong.model.SongForm;
import com.codegym.springuploadsong.service.SongService;
import com.codegym.springuploadsong.service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;

    private final SongService songService = new SongServiceImpl();

    @GetMapping("")
    public String index(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("songForm") SongForm songForm) {
        MultipartFile multipartFile = songForm.getSong();
        String fileName = multipartFile.getOriginalFilename();

        // ✅ Kiểm tra định dạng file
        if (fileName != null && !fileName.matches(".*\\.(mp3|wav|ogg|m4p)$")) {
            ModelAndView modelAndView = new ModelAndView("/create");
            modelAndView.addObject("songForm", songForm);
            modelAndView.addObject("error", "Chỉ chấp nhận file .mp3, .wav, .ogg, .m4p!");
            return modelAndView;
        }


        try {
            FileCopyUtils.copy(songForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getName(), songForm.getArtist(), songForm.getStyle(), fileName);
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", new SongForm());
        modelAndView.addObject("success", "Thêm bài hát thành công!");
        return modelAndView;
    }
}
