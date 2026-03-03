package com.example.Lab05_MySQLconnect.services;

import com.example.Lab05_MySQLconnect.model.Category;
import com.example.Lab05_MySQLconnect.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public List<Category> getAll(){
        return repository.findAll();
    }
}
