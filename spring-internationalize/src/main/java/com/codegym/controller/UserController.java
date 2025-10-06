package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ILoginService loginService;
    @Autowired
    private MessageSource messageSource;

    // Hiển thị form đăng ký
    @GetMapping("/register")
    public String showRegisterForm(@RequestParam(value = "lang", required = false, defaultValue = "en") String lang,
                                   Model model) {
        model.addAttribute("lang", lang);
        model.addAttribute("user", new User());
        return "register";
    }

    // Xử lý đăng ký
    @PostMapping("/register")
    public String register(@Validated @ModelAttribute User user,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model,
                           Locale locale) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        // Check trùng username
        if (loginService.findByUsername(user.getUsername()) != null) {
            String errorMessage = messageSource.getMessage("register.username.duplicate", null, locale);
            model.addAttribute("error", errorMessage);
            return "register";
        }

        // Lưu user vào ArrayList
        loginService.save(user);
        String successMessage = messageSource.getMessage("register.success", null, locale);
        redirectAttributes.addFlashAttribute("message", successMessage);
        return "redirect:/user/login";
    }

    // Hiển thị form login
    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "lang", required = false, defaultValue = "en") String lang,
                                Model model) {
        model.addAttribute("lang", lang);
        model.addAttribute("user", new User());
        return "login";
    }

    // Xử lý login
    @PostMapping("/doLogin")
    public ModelAndView login(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();

        User existingUser = loginService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            modelAndView.setViewName("dashboard");
            modelAndView.addObject("user", existingUser);
        } else {
            modelAndView.setViewName("login");
            modelAndView.addObject("error", "Sai username hoặc password!");
        }

        return modelAndView;
    }
}
