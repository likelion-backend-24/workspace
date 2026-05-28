package book;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("도서 저장")
    void save() {

        Book book = new Book(
                "모두의 자바",
                "강경미",
                "1234",
                2024
        );

        Book savedBook =
                bookRepository.save(book);

        assertThat(savedBook.getId())
                .isNotNull();

        assertThat(savedBook.getTitle())
                .isEqualTo("모두의 자바");

        assertThat(savedBook.getAuthor())
                .isEqualTo("강경미");

        assertThat(savedBook.getAvailable())
                .isTrue();
    }

    @Test
    @DisplayName("저자로 검색")
    void findByAuthor() {

        bookRepository.save(
                new Book(
                        "모두의 자바",
                        "강경미",
                        "1111",
                        2024
                )
        );

        List<Book> books =
                bookRepository.findByAuthor("강경미");

        assertThat(books)
                .extracting(Book::getAuthor)
                .contains("강경미");
    }

    @Test
    @DisplayName("제목 키워드 검색")
    void findByTitleContaining() {

        bookRepository.save(
                new Book(
                        "모두의 자바",
                        "강경미",
                        "2222",
                        2024
                )
        );

        List<Book> books =
                bookRepository.findByTitleContaining("자바");

        assertThat(books)
                .extracting(Book::getTitle)
                .contains("모두의 자바");
    }

    @Test
    @DisplayName("ISBN으로 검색")
    void findByIsbn() {

        bookRepository.save(
                new Book(
                        "모두의 자바",
                        "강경미",
                        "3333",
                        2024
                )
        );

        Book book =
                bookRepository.findByIsbn("3333");

        assertThat(book.getTitle())
                .isEqualTo("모두의 자바");
    }

    @Test
    @DisplayName("저자 검색 + 출판연도 내림차순")
    void findByAuthorOrderByPublishYearDesc() {

        bookRepository.save(
                new Book(
                        "모두의 자바 초급",
                        "강경미",
                        "4444",
                        2022
                )
        );

        bookRepository.save(
                new Book(
                        "모두의 자바 실전",
                        "강경미",
                        "5555",
                        2025
                )
        );

        List<Book> books =
                bookRepository.findByAuthorOrderByPublishYearDesc("강경미");

        assertThat(books.getFirst().getPublishYear())
                .isEqualTo(2025);
    }

    @Test
    @DisplayName("출판연도 범위 검색")
    void findByPublishYearBetween() {

        bookRepository.save(
                new Book(
                        "모두의 자바 입문",
                        "강경미",
                        "6666",
                        2021
                )
        );

        bookRepository.save(
                new Book(
                        "모두의 자바 웹개발",
                        "강경미",
                        "7777",
                        2024
                )
        );

        List<Book> books =
                bookRepository.findByPublishYearBetween(2022, 2025);

        assertThat(books)
                .extracting(Book::getPublishYear)
                .contains(2024);
    }

    @Test
    @DisplayName("대여 가능한 도서 조회")
    void findByAvailableTrue() {

        Book book1 =
                new Book(
                        "모두의 자바",
                        "강경미",
                        "8888",
                        2024
                );

        Book book2 =
                new Book(
                        "모두의 스프링",
                        "강경미",
                        "9999",
                        2025
                );

        book2.setAvailable(false);

        bookRepository.save(book1);
        bookRepository.save(book2);

        List<Book> books =
                bookRepository.findByAvailableTrue();

        assertThat(books)
                .extracting(Book::getTitle)
                .contains("모두의 자바")
                .doesNotContain("모두의 스프링");
    }
}