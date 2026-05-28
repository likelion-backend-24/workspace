package springdatajdbc01;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("사용자 저장")
    void saveUser() {

        User user = new User("kang", "kang@test.com");

        User savedUser = userRepository.save(user);

        assertThat(savedUser.getId()).isNotNull();
    }

    @Test
    @DisplayName("이름으로 사용자 조회")
    void findByName() {

        userRepository.save(new User("kim", "kim1@test.com"));
        userRepository.save(new User("kim", "kim2@test.com"));

        List<User> users = userRepository.findByName("kim");

        assertThat(users).hasSizeGreaterThanOrEqualTo(2);

        assertThat(users)
                .extracting(User::getName)
                .containsOnly("kim");
    }

    @Test
    @DisplayName("이메일로 사용자 조회")
    void findByEmail() {

        userRepository.save(
                new User("lee", "lee@test.com")
        );

        List<User> users =
                userRepository.findByEmail("lee@test.com");

        assertThat(users)
                .extracting(User::getEmail)
                .contains("lee@test.com");
    }

    @Test
    @DisplayName("전체 사용자 조회")
    void findAll() {

        userRepository.save(new User("user1", "u1@test.com"));
        userRepository.save(new User("user2", "u2@test.com"));

        Iterable<User> users = userRepository.findAll();

        assertThat(users).isNotEmpty();
    }

    @Test
    @DisplayName("사용자 삭제")
    void deleteUser() {

        User user =
                userRepository.save(
                        new User("delete", "delete@test.com")
                );

        userRepository.deleteById(user.getId());

        boolean result =
                userRepository.findById(user.getId())
                        .isEmpty();

        assertThat(result).isTrue();
    }
}