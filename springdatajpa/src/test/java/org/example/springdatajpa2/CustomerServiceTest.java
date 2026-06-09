package org.example.springdatajpa2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    @Test
    @DisplayName("고객생성")
    void createCustomer(){
        Customer hong = service.createCustomer("hong", "hong@hong.com", 22);

        assertThat(hong).isNotNull();
        assertThat(hong.getId()).isNotNull();
        assertThat(hong.getName()).isEqualTo("hong");
    }


    @Test
    @DisplayName("고객조회")
    void findCustomer(){

    }

}