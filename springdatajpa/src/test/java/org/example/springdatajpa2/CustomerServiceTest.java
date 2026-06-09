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
        Customer saved = service.createCustomer("김철수", "kim@test.com", 30);

        Customer found = service.findCustomer(saved.getId());

        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("김철수");
        assertThat(found.getEmail()).isEqualTo("kim@test.com");

    }

    @Test
    @DisplayName("존재하지 않는 이메일 조회 시 예외 발생")
    void findByEmailNotFound() {
        assertThatThrownBy(() -> service.findByEmail("notfound@test.com"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 이메일의 고객이 없습니다");
    }

}