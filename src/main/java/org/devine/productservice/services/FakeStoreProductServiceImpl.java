package org.devine.productservice.services;

import org.devine.productservice.dtos.CreateProductRequestDTO;
import org.devine.productservice.dtos.FakeStoreProductDTO;
import org.devine.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getProductDetails(Long id) {
        System.out.println("Getting product details from fake store");
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        return fakeStoreProductDTO.toProduct();
    }

    /**
     * @param title
     * @param price
     * @param description
     * @param category
     * @param imageUrl
     */
    @Override
    public Product  createProduct(String title, Double price, String description, String category, String imageUrl) {
        CreateProductRequestDTO p = new CreateProductRequestDTO();
        p.setImageUrl(imageUrl);
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setCategory(category);
        FakeStoreProductDTO responsedto = restTemplate.postForObject("https://fakestoreapi.com/products", p, FakeStoreProductDTO.class);
        return responsedto.toProduct();
    }

    /**
     * @return
     */
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] responseArray= restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO dto : responseArray){
            products.add(dto.toProduct());
        }

        return products;
    }
}
