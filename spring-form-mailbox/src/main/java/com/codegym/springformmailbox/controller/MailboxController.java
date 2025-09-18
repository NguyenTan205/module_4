package com.codegym.springformmailbox.controller;

import com.codegym.springformmailbox.model.Mailbox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mailbox")
public class MailboxController {

    @GetMapping("/show-form")
    public String showForm(Model model) {
        model.addAttribute("mailbox", new Mailbox());
        return "mailbox/create";
    }

    @PostMapping("/add-mailbox")
    public String submit(@ModelAttribute("mailbox") Mailbox mailbox, Model model) {
        model.addAttribute("languages", mailbox.getLanguages());
        model.addAttribute("pageSize", mailbox.getPageSize());
        model.addAttribute("spamsFilter", mailbox.isSpamsFilter());
        model.addAttribute("signature", mailbox.getSignature());
        return "mailbox/info";
    }
}
