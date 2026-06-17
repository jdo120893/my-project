package org.example.restexam.Controller;

import jakarta.validation.Valid;
import lombok.Value;
import org.example.restexam.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping(value = "/xml", produces = "application/xml")
    public List<ProductDTO> getProductsAsxml(){
        List<ProductDTO> products = Arrays.asList(
                new ProductDTO(1L,"Laptop",999),
                new ProductDTO(2L,"Mouse",29)
        );

        return products;
    }

    @GetMapping
    public List<ProductDTO> getProducts(){
        List<ProductDTO> products = Arrays.asList(
                new ProductDTO(1L,"Laptop",999),
                new ProductDTO(2L,"Mouse",29)
        );

        return products;
    }


    @PostMapping
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO){

        return productDTO;
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){

        return productDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(){

    }


}
