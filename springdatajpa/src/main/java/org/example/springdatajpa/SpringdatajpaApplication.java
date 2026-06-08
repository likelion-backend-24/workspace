package org.example.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringdatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository repository, UserService service){
        return args -> {
            service.addUser(new User("kang","kang@lion.com"));


//            User user = new User("carami","carami@gmailc.com");
//            repository.save(user);
//
//            Optional<User> user1 = repository.findById(11L);
//
//
//            User user2 = repository.findById(1L).get();
//            repository.delete(user2);
//



// get - 그냥 꺼내줘요!!!
//            User getUser = user1.get();
//            getUser.getId();

// orElse - null이 아니라면 가져온값 주고,  null 이라면 대안으로 제시한 값을 주세요.
//            User guestUser = user1.orElse(new User("guestUser", "guest@guest.com"));

//            orElseThrow
//            User findUser = user1.orElseThrow(() -> new RuntimeException("예외발생"));


        };

    }
}
