package com.example.Lab05_MySQLconnect.controllers;

import com.example.Lab05_MySQLconnect.model.Product;
import com.example.Lab05_MySQLconnect.model.Category;
import com.example.Lab05_MySQLconnect.services.CategoryService;
import com.example.Lab05_MySQLconnect.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final CategoryService categoryService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", service.getAll());
        return "product-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAll());
        return "product-add";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = service.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAll());
        return "product-edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product,
                       @RequestParam("file") MultipartFile file) {

        try {
            if (!file.isEmpty()) {

                String uploadDir = "src/main/resources/static/images/";
                String fileName = file.getOriginalFilename();

                Path path = Paths.get(uploadDir + fileName);
                Files.write(path, file.getBytes());

                product.setImgUrl("images/" + fileName);
            }

            service.save(product);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/products";
    }
}