package com.app.SecondGadgetApp.Controller;

import com.app.SecondGadgetApp.Dto.ProductsDTO;
import com.app.SecondGadgetApp.Dto.ResponseDTO;
import com.app.SecondGadgetApp.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/product")
public class ProductsController
{
    @Autowired
    ProductsService productsService;

    @PostMapping("/add")
    public ResponseEntity<?> add(ProductsDTO productsDTO, @RequestParam("photo") MultipartFile file) throws IOException
    {
        productsDTO.setPhoto(file);
        productsService.add_product(productsDTO);
        return new ResponseEntity<>(new ResponseDTO("201", "product added"), HttpStatus.CREATED);
    }

    @PostMapping("/preview")
    public ResponseEntity<?> preview(ProductsDTO productsDTO, @RequestParam("photo") MultipartFile file) throws IOException
    {
        productsDTO.setPhoto(file);
        productsService.preview_product(productsDTO);
        return new ResponseEntity<>(new ResponseDTO("201", "preview added"), HttpStatus.CREATED);
    }

    @GetMapping("/display-all")
    public ResponseEntity<?> display_all()
    {
        return new ResponseEntity<>(new ResponseDTO("200", "success", productsService.display_all()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<?> display_product(@PathVariable("id") Long id)
    {
        if(productsService.display_product(id) != null)
        {
            return new ResponseEntity<>(new ResponseDTO("200","success", productsService.display_product(id)), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new ResponseDTO("404","product not found"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/display-status/{status}")
    public ResponseEntity<?> display_status(@PathVariable("status") String status)
    {
        if(productsService.display_status(status) != null)
        {
            return new ResponseEntity<>(new ResponseDTO("200", "success", productsService.display_status(status)), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new ResponseDTO("404", "product not found"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update_product(@PathVariable("id") Long id, ProductsDTO productsDTO, @RequestParam("photo") MultipartFile file) throws IOException
    {
        productsDTO.setPhoto(file);
        return new ResponseEntity<>(new ResponseDTO("200", "success", productsService.update_product(id, productsDTO)), HttpStatus.OK);
    }
}
