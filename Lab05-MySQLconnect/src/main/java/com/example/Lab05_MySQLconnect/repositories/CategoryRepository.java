package com.example.Lab05_MySQLconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Lab05_MySQLconnect.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}