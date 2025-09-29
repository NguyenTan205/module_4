package com.codegym.controller;

import com.codegym.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {
    @ModelAttribute("cart") //Tạo đối tượng giỏ hàng (Cart) và lưu vào session để sử dụng trong các request sau.
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart") //Hiển thị giỏ hàng hiện tại.
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
}