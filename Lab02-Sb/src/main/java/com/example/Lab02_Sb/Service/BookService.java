package com.example.Lab02_Sb.Service;

import com.example.Lab02_Sb.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public BookService(){
        books.add(new Book(1, "Vòng đời lập trình viên", "Tấn"));
        books.add(new Book(2, "Hayyy", "Tôi đi code dạo"));
    }


    //get all books
    public List<Book> GetAllBooks (){
        return books;
    }

    public Book GetBookById(int id){
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    //add
    public void addBook(Book book){
        books.add(book);
    }

    //update
    public void updateBook(int id, Book updatedBook){
        books.stream().filter(b -> b.getId() == id).findFirst().ifPresent(b ->{
            b.setTitle(updatedBook.getTitle());
            b.setAuthor(updatedBook.getAuthor());
        });
    }

    //delete
    public void deleteBook(int id){
        books.removeIf(b -> b.getId() == id);
    }
}




