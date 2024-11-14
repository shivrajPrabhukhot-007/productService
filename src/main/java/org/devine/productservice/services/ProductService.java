package org.devine.productservice.services;

import org.devine.productservice.dtos.FakeStoreProductDTO;
import org.devine.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductDetails(Long id);
    public Product createProduct(String title, Double price, String description, String category, String imageUrl);
    public List<Product> getAllProducts();
}
