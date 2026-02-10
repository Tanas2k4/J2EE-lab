package com.example.Lab04_Ecom.controller;

import com.example.Lab04_Ecom.model.Category;
import com.example.Lab04_Ecom.model.Product;
import com.example.Lab04_Ecom.service.CategoryService;
import com.example.Lab04_Ecom.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    // ================== LIST ==================
    @GetMapping
    public String index(Model model) {
        model.addAttribute("listProduct", productService.getALL());
        return "products/index";   // ✅ ĐÚNG
    }

    // ================== CREATE ==================
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newProduct", new Product());
        model.addAttribute("listCategory", categoryService.getALL());
        return "products/create";  // ✅ ĐÚNG
    }

    @PostMapping("/create")
    public String create(
            @Valid @ModelAttribute("newProduct") Product newProduct,
            BindingResult result,
            @RequestParam("imageProduct") MultipartFile imageProduct,
            Model model) {

        if (newProduct.getCategory() == null) {
            result.rejectValue("category", "error.category", "Please select category");
        }

        if (result.hasErrors()) {
            model.addAttribute("listCategory", categoryService.getALL());
            return "products/create";
        }

        Category category = categoryService.get(newProduct.getCategory().getId());
        newProduct.setCategory(category);

        productService.updateImage(newProduct, imageProduct);
        productService.add(newProduct);

        return "redirect:/products";
    }

    // ================== EDIT ==================
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Product product = productService.get(id);
        if (product == null) {
            return "error/404";
        }
        model.addAttribute("editProduct", product);
        model.addAttribute("listCategory", categoryService.getALL());
        return "products/edit";   // ✅ ĐÚNG
    }

    @PostMapping("/edit")
    public String edit(
            @Valid @ModelAttribute("editProduct") Product editProduct,
            BindingResult result,
            @RequestParam("imageProduct") MultipartFile imageProduct,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("listCategory", categoryService.getALL());
            return "products/edit";
        }

        if (imageProduct != null && !imageProduct.isEmpty()) {
            productService.updateImage(editProduct, imageProduct);
        }

        productService.update(editProduct);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
