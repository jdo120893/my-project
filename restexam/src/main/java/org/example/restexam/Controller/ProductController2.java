package org.example.restexam.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.coyote.Response;
import org.example.restexam.dto.ProductDTO;
import org.example.restexam.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api2/products")
@RequiredArgsConstructor
public class ProductController2 {
    private final ProductService service;

    @GetMapping(value = "/xml", produces = "application/xml")
    public ResponseEntity<List<ProductDTO>> getProductsAsxml(){
        List<ProductDTO> products = Arrays.asList(
                new ProductDTO(1L,"Laptop",999),
                new ProductDTO(2L,"Mouse",29)
        );

        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestHeader("Accept") String acceptHeader){
        System.out.println(acceptHeader);

        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductDTO>> getProduct(@PathVariable("id")Long id){

        return ResponseEntity.ok(service.getProducts());
    }


    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){

//        if (ProductDTO.getName()!=null)
        ProductDTO product = service.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id")Long id, @RequestBody ProductDTO productDTO){
        productDTO.setId(id);
        return ResponseEntity.ok(service.updateProduct(productDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
