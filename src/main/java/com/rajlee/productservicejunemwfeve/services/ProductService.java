package com.rajlee.productservicejunemwfeve.services;

import com.rajlee.productservicejunemwfeve.models.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);
    List<Product> getAllProducts();
    Product replaceProduct(Long id,Product product);
}
