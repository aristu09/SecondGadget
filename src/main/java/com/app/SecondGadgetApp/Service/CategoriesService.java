package com.app.SecondGadgetApp.Service;

import com.app.SecondGadgetApp.Dto.CategoriesDTO;
import com.app.SecondGadgetApp.Entity.Categories;
import com.app.SecondGadgetApp.Repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CategoriesService
{
    @Autowired
    CategoriesRepo categoriesRepo;

    public Categories add_category(CategoriesDTO categoriesDTO) throws IOException
    {
        Categories categories = new Categories();

        categories.setPhoto(categoriesDTO.getPhoto().getBytes());
        categories.setName(categoriesDTO.getName());

        return categoriesRepo.save(categories);
    }

    public List<Categories> display_all()
    {
        return categoriesRepo.findAll();
    }

    public Categories display_category(Long categoryId)
    {
        return categoriesRepo.findByCategoryId(categoryId);
    }

    public Categories update_category(Long categoryId, CategoriesDTO categoriesDTO)
    {
        Categories categories = categoriesRepo.findByCategoryId(categoryId);
        try
        {
            categories.setPhoto(categoriesDTO.getPhoto().getBytes());
            categories.setName(categoriesDTO.getName());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return categoriesRepo.save(categories);
    }
}
