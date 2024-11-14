package org.devine.productservice.repositories;

import org.devine.productservice.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    public Category save(Category category);

    boolean existsByName(String category);

    Category findByName(String category);
}
