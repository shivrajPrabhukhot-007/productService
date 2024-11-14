package org.devine.productservice.controllers;

import org.devine.productservice.dtos.CreateProductRequestDTO;
import org.devine.productservice.dtos.FakeStoreProductDTO;
import org.devine.productservice.models.Product;
import org.devine.productservice.services.FakeStoreProductServiceImpl;
import org.devine.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("databaseProductService")
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products,
                HttpStatus.OK);
        if (products != null) {
            return responseEntity;
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductDetailsById(@PathVariable("id") Long id) {
        Product product = productService.getProductDetails(id);
        ResponseEntity<Product> responseEntity = new ResponseEntity(product, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDTO requestDTO) {
        Product product = productService.createProduct(
                requestDTO.getTitle(),
                requestDTO.getPrice(),
                requestDTO.getDescription(),
                requestDTO.getCategory(),
                requestDTO.getImageUrl());

        ResponseEntity<Product> responseEntity = new ResponseEntity(product, HttpStatusCode.valueOf(201));
        return responseEntity;
    }
}
