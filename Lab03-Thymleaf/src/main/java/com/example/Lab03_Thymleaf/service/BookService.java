package com.example.Lab03_Thymleaf.service;

import com.example.Lab03_Thymleaf.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Long nextId =1l;



    //get all books
    public List<Book> GetAllBooks (){
        return books;
    }

    public Optional<Book> GetBookById(long id){
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    //add
    public void addBook(Book book){
        book.setId(nextId++);
        books.add(book);
    }

    //update
    public void updateBook(long id, Book updatedBook){
        books.stream().filter(b -> b.getId() == id).findFirst().ifPresent(b ->{
            b.setTitle(updatedBook.getTitle());
            b.setAuthor(updatedBook.getAuthor());
        });
    }

    //delete
    public void deleteBook(long id){
        books.removeIf(b -> b.getId() == id);
    }
}

