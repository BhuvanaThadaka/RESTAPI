package com.rajlee.productservicejunemwfeve.services;

import com.rajlee.productservicejunemwfeve.models.Product;
import com.rajlee.productservicejunemwfeve.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    FakeStoreProductService fakeStoreProductService;

    @Override
    public Product findById(Long id) {

        Product product = fakeStoreProductService.findById(id);
        productRepository.save(product);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
