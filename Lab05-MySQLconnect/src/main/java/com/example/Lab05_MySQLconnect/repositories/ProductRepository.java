package com.example.Lab05_MySQLconnect.repositories;

import com.example.Lab05_MySQLconnect.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
