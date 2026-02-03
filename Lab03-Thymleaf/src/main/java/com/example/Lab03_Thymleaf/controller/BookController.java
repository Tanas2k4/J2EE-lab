package com.example.Lab03_Thymleaf.controller;


import com.example.Lab03_Thymleaf.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Lab03_Thymleaf.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(Model model){
        model.addAttribute("books", bookService.GetAllBooks());
        return "books";
    }

    //Hiển thị form thêm sách
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        return "add-book";
    }

    //Thêm sách mới
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String updateBookForm(@PathVariable long id, Model model){
        bookService.GetBookById(id)
                .ifPresent(book -> model.addAttribute("book", book));
        return "edit-book";
    }

    @PostMapping("/edit")
    public String updateBook(@RequestParam long id,
                             @ModelAttribute Book book){
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

}

