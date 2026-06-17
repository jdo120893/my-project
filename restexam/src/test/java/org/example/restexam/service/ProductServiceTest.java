package org.example.restexam.service;

import lombok.extern.slf4j.Slf4j;
import org.example.restexam.dto.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
@Transactional
@Slf4j
class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Test
    @DisplayName("상품을 추가할 수 있다.")
    void createProduct() {
        ProductDTO productDTO = ProductDTO.builder()
                .name("키보드")
                .price(40000)
                .build();

        ProductDTO product = productService.createProduct(productDTO);

        assertThat(product.getId()).isNotNull();
        assertThat(product.getName()).isEqualTo("키보드");

    }

    @Test
    @DisplayName("전체상품 조회")
    void getProducts(){
        productService.getProducts().forEach(System.out::println);
    }

    @Test
    @DisplayName("특정상품 조회")
    void getProduct(){
        ProductDTO product = productService.createProduct(ProductDTO.builder()
                .name("노트북")
                .price(1500000)
                .build());
        ProductDTO foundProduct = productService.getProduct(product.getId());
        assertThat(foundProduct).isNotNull();
        assertThat(foundProduct.getName()).isEqualTo("노트북");
    }

    @Test
    @DisplayName("상품정보 수정")
    void updateProducts(){

    }

    @Test
    @DisplayName("상품삭제")
    void deleteProducts(){

    }
}