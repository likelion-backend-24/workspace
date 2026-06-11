package org.example.restexam.service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Product;
import org.example.restexam.dto.ProductDTO;
import org.example.restexam.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    //crud

    //상품추가
    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO){
//        dto 로 들고 온 값을 엔티티로 바꿔줘야겠네요.
//        Product product = Product.builder()
//                        .name(productDTO.getName())
//                                .price(productDTO.getPrice())
//                                        .build();


        Product saveProduct = repository.save(Product.formDTO(productDTO));
//        엔티티에 들어있는 값을 dto에 옮겨 담아야겠네요.
        return ProductDTO.fromEntity(saveProduct);
    }


}
