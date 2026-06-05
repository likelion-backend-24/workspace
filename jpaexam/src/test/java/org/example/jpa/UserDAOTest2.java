package org.example.jpa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserDAOTest2 {
    private static final UserDAO userDAO = new UserDAO();

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setName("kang");
        user.setEmail("kang@test.com");
    }

    @AfterAll
    static void close() {
        userDAO.close();
    }

    @Test
    @DisplayName("사용자 등록")
    void createUser() {

        userDAO.createUser(user);

        assertThat(user.getId()).isNotNull();
    }
}
