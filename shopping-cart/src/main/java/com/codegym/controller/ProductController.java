package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart") //Khai báo rằng đối tượng "cart" sẽ được lưu trữ trong session.
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart") //Tạo đối tượng giỏ hàng (Cart) và lưu vào session để sử dụng trong các request sau.
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop") //Hiển thị danh sách sản phẩm từ productService để người dùng chọn mua.
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}") //Xử lý việc thêm sản phẩm vào giỏ hàng dựa trên ID sản phẩm và hành động (action) được chỉ định.
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
}