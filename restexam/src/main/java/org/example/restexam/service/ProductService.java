package org.example.restexam.service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.Domain.Product;
import org.example.restexam.dto.ProductDTO;

import org.example.restexam.repository.ProductRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository repository;

    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO){
//        Product product = Product.builder()
//                .name(productDTO.getName())
//                .price(productDTO.getPrice())
//                .build();



        Product saveProduct = repository.save(Product.formDTO(productDTO));
        return productDTO.fromEntity(saveProduct);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getProducts(){
        return repository.findAll().stream().map(ProductDTO::fromEntity).toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO getProduct(Long id){
        Product product = repository.findById(id).orElseThrow(()->new RuntimeException("상품이 존재하지 않습니다. :: "+ id));
        return ProductDTO.fromEntity(product);
    }

    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO){
        Product product = repository.findById(productDTO.getId())
                .orElseThrow(()-> new RuntimeException("수정할 상품이 존재하지 않습니다."));

//        if (productDTO.getName() != null)
//        product.setName(productDTO.getName());

        Optional.ofNullable(productDTO.getName()).ifPresent(product::setName);

//        if(productDTO.getPrice() != 0)
//            product.setPrice(productDTO.getPrice());

        Optional.ofNullable(productDTO.getPrice()).ifPresent(product::setPrice);


        return ProductDTO.fromEntity(product);
    }

    @Transactional
    public void deleteProduct(Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("삭제할 상품이 존재하지 않습니다. id:: "+id);
        }
        repository.deleteById(id);

    }

}
