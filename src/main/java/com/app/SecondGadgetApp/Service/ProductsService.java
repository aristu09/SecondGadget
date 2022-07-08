package com.app.SecondGadgetApp.Service;

import com.app.SecondGadgetApp.Dto.ProductsDTO;
import com.app.SecondGadgetApp.Entity.Products;
import com.app.SecondGadgetApp.Repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductsService
{
    @Autowired
    ProductsRepo productsRepo;

    public Products add_product(ProductsDTO productsDTO) throws IOException
    {
        Products products = new Products();

        products.setUserId(productsDTO.getUserId());
        products.setCategoryId(productsDTO.getCategoryId());
        products.setName(productsDTO.getName());
        products.setSerialNumber(productsDTO.getSerialNumber());
        products.setPrice(productsDTO.getPrice());
        products.setDescription(productsDTO.getDescription());
        products.setStatus("available");
        products.setPhoto(productsDTO.getPhoto().getBytes());

        return productsRepo.save(products);
    }
    public Products preview_product(ProductsDTO productsDTO) throws IOException
    {
        Products products = new Products();

        products.setUserId(productsDTO.getUserId());
        products.setCategoryId(productsDTO.getCategoryId());
        products.setName(productsDTO.getName());
        products.setSerialNumber(productsDTO.getSerialNumber());
        products.setPrice(productsDTO.getPrice());
        products.setDescription(productsDTO.getDescription());
        products.setStatus("draft");
        products.setPhoto(productsDTO.getPhoto().getBytes());

        return productsRepo.save(products);
    }

    public List<Products> display_all()
    {
        return productsRepo.findAll();
    }

    public Products display_product(Long productId)
    {
        return productsRepo.findByProductId(productId);
    }

    public List<Products> display_status(String status)
    {
        return productsRepo.findByStatus(status);
    }

    public Products update_product(Long productId, ProductsDTO productsDTO)
    {
        Products products = productsRepo.findByProductId(productId);

        try
        {
            products.setUserId(productsDTO.getUserId());
            products.setCategoryId(productsDTO.getCategoryId());
            products.setName(productsDTO.getName());
            products.setSerialNumber(productsDTO.getSerialNumber());
            products.setPrice(productsDTO.getPrice());
            products.setDescription(productsDTO.getDescription());
            products.setPhoto(productsDTO.getPhoto().getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return productsRepo.save(products);
    }

    public void update_status(String status, Long productId)
    {
        Products products = productsRepo.findByProductId(productId);
        products.setStatus(status);
        productsRepo.save(products);
    }
}
