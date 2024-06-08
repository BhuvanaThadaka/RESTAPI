package com.rajlee.productservicejunemwfeve.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;
    private String description;

    @ManyToOne
    private Category category;

    @OneToOne
    private Rating rating;

    private String imageUrl;
}
