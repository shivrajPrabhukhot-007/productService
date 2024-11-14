package org.devine.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.devine.productservice.models.Category;
import org.devine.productservice.models.Product;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String imageUrl;

    public Product toProduct(){
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        Category category = new Category();
        category.setName(getCategory());
        product.setCategory(category);
        product.setDescription(getDescription());
        product.setPrice(getPrice());
        product.setImageUrl(getImageUrl());
        return product;
    }
}
