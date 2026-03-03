package com.example.Lab05_MySQLconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private Double price;

    @Column(name = "product_name", nullable = false, length = 200)
    private String name;

    @Column(name = "image_url", length = 500)
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Transient
    private Double discountedPrice;
}
