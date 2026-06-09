package org.example.springdatajpa2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
//    고객추가
@Transactional
public Customer createCustomer(String name, String email, int age) {
    Customer customer = new Customer(name, email);
    customer.setAge(age);
    return customerRepository.save(customer);
}
//    고객정보 조회 (id)

//    고객정보 전체조회

//    고객정보수정

//    고객정보 삭제

//    고객정보조회 (email)

//
}
