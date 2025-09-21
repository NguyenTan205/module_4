package com.codegym.ormsonglisten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.codegym.ormsonglisten.model.BaiHat;
import com.codegym.ormsonglisten.service.BaiHatService;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/baihat")
public class BaiHatController {

    @Autowired
    private BaiHatService baiHatService;
    @Value("${file-upload}")
    private String upload;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", baiHatService.findAll());
        return "baihat/list";
    }

    @GetMapping("/create")
    public String createBaiHat(Model model) {
        model.addAttribute("baihat", new BaiHat());
        // forward
        return "baihat/create";
    }

    @PostMapping("/create")
    public String saveBaiHat(@ModelAttribute("baihat") BaiHat baihat) {
        MultipartFile file = baihat.getFile();
        if (file != null && !file.isEmpty()) {
            try {
                baihat.setFileBaiHat(file.getOriginalFilename());
                File dir = new File(upload);
                if (!dir.exists()) dir.mkdirs();
                File dest = new File(upload, file.getOriginalFilename());
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        baiHatService.save(baihat);
        return "redirect:/baihat";
    }

    @GetMapping("/edit/{id}")
    public String editBaiHat(@PathVariable("id") Long id, Model model) {
        model.addAttribute("baihat", baiHatService.findById(id));
        // forward
        return "baihat/edit";
    }

    @PostMapping("/edit")
    public String editBaiHat(@ModelAttribute("baihat") BaiHat baihat) {
        MultipartFile file = baihat.getFile();
        if (file != null && !file.isEmpty()) {
            try {
                baihat.setFileBaiHat(file.getOriginalFilename());
                File dir = new File(upload);
                if (!dir.exists()) dir.mkdirs();
                File dest = new File(upload, file.getOriginalFilename());
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        baiHatService.save(baihat);
        return "redirect:/baihat";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        BaiHat baihat = baiHatService.findById(id);
        if (baihat != null) {
            baiHatService.delete(id);
        }
        return "redirect:/baihat";
    }
}