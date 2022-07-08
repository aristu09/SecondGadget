package com.app.SecondGadgetApp.Repository;

import com.app.SecondGadgetApp.Entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepo extends JpaRepository<Categories, Long>
{
    Categories findByCategoryId(Long categoryId);
}
