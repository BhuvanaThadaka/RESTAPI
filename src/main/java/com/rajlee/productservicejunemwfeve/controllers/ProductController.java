package com.rajlee.productservicejunemwfeve.controllers;

import com.rajlee.productservicejunemwfeve.models.Product;
import com.rajlee.productservicejunemwfeve.services.ProductService;
import com.rajlee.productservicejunemwfeve.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;


    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> response = new ResponseEntity<>(productServiceImpl.getAllProducts(), HttpStatus.FORBIDDEN);
        return response;
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        //throw new RuntimeException("Something went wrong");
//                 try {
//                        return new ResponseEntity<>(
//              productService.getSingleProduct(id),
//               HttpStatus.OK);
//        } catch (ArithmeticException exception) {
//            ResponseEntity<Product> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return response;
//        } catch (ArrayIndexOutOfBoundsException exception) {
//
//        }
   return productServiceImpl.findById(id);
    }
    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){
        Product p=new Product();
        p.setTitle("A new Product");
        return p;
    }
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return new Product();
    }
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return new Product();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
         return new ResponseEntity<>(HttpStatus.OK);
    }
}
