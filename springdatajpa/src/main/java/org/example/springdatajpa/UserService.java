package org.example.springdatajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    CRUD 에 해당하는 메서드들을 구현해보세요.
    public User addUser(User user){
        return userRepository.save(user);
    }
}
