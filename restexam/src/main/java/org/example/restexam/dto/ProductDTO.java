package org.example.restexam.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.restexam.domain.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    @NotBlank(message = "상품명은 반드시 입력해야 합니다.")
    private String name;
    @Min(value = 100, message = "상품 가격은 100원 이상이어야 합니다.")
    private int price;

//    Entity -- > DTO 로 변환하는 메서드
    public static ProductDTO fromEntity(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
