package com.codegym.sping_caculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {
        return "index";
    }

    @RequestMapping(value = "/caculate", method = RequestMethod.POST)
    public String caculate(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("operator") String operator,
            Model model) {

        double result = 0;
        String message = "";

        switch (operator) {
            case "+":
                result = num1 + num2;
                message = "Result: " + result;
                break;
            case "-":
                result = num1 - num2;
                message = "Result: " + result;
                break;
            case "*":
                result = num1 * num2;
                message = "Result: " + result;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                    message = "Result: " + result;
                } else {
                    message = "Lỗi không thể chia cho 0";
                }
                break;
            default:
                message = "Toán tử không hợp lệ!";
        }
        model.addAttribute("message", message);
        return "index";
    }
}
