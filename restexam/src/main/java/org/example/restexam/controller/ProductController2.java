package org.example.restexam.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.restexam.dto.ProductDTO;
import org.example.restexam.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api2/products")
@RequiredArgsConstructor
public class ProductController2 {
    private final ProductService service;

    @GetMapping(value = "/xml", produces = "application/xml")
    public ResponseEntity<List<ProductDTO>> getProductsAsXml(){
        List<ProductDTO> products = Arrays.asList(
                new ProductDTO(1L, "Laptop", 999),
                new ProductDTO(2L, "Mouse", 29)
        );

        return ResponseEntity.ok(products);
    }
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestHeader("Accept") String accptHeader){
        System.out.println(accptHeader);


        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") Long id){

        return ResponseEntity.ok(service.getProduct(id));
    }
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){

//        if(productDTO.getName()!=null)
//            R
        ProductDTO product = service.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id")Long id,@RequestBody ProductDTO productDTO){
        productDTO.setId(id);
        return ResponseEntity.ok(service.updateProduct(productDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);
        return ResponseEntity.ok("삭제성공!!");
    }

}
