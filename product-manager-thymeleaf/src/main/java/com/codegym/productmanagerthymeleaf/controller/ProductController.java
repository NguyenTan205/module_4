package com.codegym.productmanagerthymeleaf.controller;

import com.codegym.productmanagerthymeleaf.model.Product;
import com.codegym.productmanagerthymeleaf.model.ProductForm;
import com.codegym.productmanagerthymeleaf.service.ProductService;
import com.codegym.productmanagerthymeleaf.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
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

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Cập nhật sản phẩm thành công!");
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
        redirectAttributes.addFlashAttribute("success", "Xoá sản phẩm thành công!");
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

    //upload file
    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/save")
    public String save(@ModelAttribute ProductForm productForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Product product = new Product(
                (int) (Math.random() * 1000),
                productForm.getName(),
                productForm.getPrice(),
                productForm.getDescription(),
                productForm.getManufacturer(),
                fileName
        );

        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Thêm sản phẩm thành công!");
        return "redirect:/products";
    }
}
