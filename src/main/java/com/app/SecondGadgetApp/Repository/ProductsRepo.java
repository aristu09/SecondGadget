package com.app.SecondGadgetApp.Repository;

import com.app.SecondGadgetApp.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepo extends JpaRepository<Products, Long>
{
    Products findByProductId(Long productId);

    List<Products> findByStatus(String status);
}
