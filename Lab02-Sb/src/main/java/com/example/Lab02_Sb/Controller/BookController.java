package com.example.Lab02_Sb.Controller;

import com.example.Lab02_Sb.Model.Book;
import com.example.Lab02_Sb.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.GetAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.GetBookById(id);
    }

    @PostMapping()
    public String addBook(@RequestBody Book book){
        bookService.addBook(book);
        return "add book successfully";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updateBook){
        bookService.updateBook(id, updateBook);
        return "update successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return "delete ok";
    }
}
