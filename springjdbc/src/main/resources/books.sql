CREATE TABLE books (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255),
                       author VARCHAR(255),
                       isbn VARCHAR(100),
                       publish_year INT,
                       available BOOLEAN,
                       created_at TIMESTAMP
);