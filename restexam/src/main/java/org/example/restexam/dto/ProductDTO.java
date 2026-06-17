package org.example.restexam.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.restexam.Domain.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    @NotBlank(message = "상품명은 반드시 입력해야 합니다.")
    private String name;
    @Min(value = 100, message = "상품 가격은 100원 이상이어야 합니다.")
    private int price;

    public static ProductDTO fromEntity(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

}
