package com.codegym.productmanagerthymeleaf.controller;

import com.codegym.productmanagerthymeleaf.model.Product;
import com.codegym.productmanagerthymeleaf.service.ProductService;
import com.codegym.productmanagerthymeleaf.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private static final ProductService productService = new ProductServiceImpl();

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm thành công!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.delete(product.getId());
        redirectAttributes.addFlashAttribute("message", "Xoá sản phẩm thành công!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<Product> products = productService.findByName(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        return "/index";
    }
}
