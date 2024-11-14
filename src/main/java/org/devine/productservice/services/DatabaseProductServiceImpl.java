package org.devine.productservice.services;

import org.devine.productservice.dtos.CreateProductRequestDTO;
import org.devine.productservice.dtos.FakeStoreProductDTO;
import org.devine.productservice.models.Category;
import org.devine.productservice.models.Product;
import org.devine.productservice.repositories.CategoryRepository;
import org.devine.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("databaseProductService")
public class DatabaseProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    /**
     * @param id
     * @return
     */
    @Override
    public Product getProductDetails(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    /**
     * @param title
     * @param price
     * @param description
     * @param category
     * @param imageUrl
     * @return
     */
    @Override
    public Product createProduct(String title, Double price, String description, String category, String imageUrl) {
        Product p = new Product();
        p.setImageUrl(imageUrl);
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        Category c = new Category();
        if(categoryRepository.existsByName(category)) {
            c = categoryRepository.findByName(category);
        }else{
            c.setName(category);
            c = categoryRepository.save(c);
        }
        p.setCategory(c);
        Product product = productRepository.save(p);
        return product;
    }


    /**
     * @return
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
