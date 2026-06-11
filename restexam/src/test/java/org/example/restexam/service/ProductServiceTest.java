package org.example.restexam.service;

import org.example.restexam.dto.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
@Transactional
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
}