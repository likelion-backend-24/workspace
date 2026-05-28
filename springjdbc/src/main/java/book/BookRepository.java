package book;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    // 저자로 검색
    List<Book> findByAuthor(String author);

    // 제목에 키워드가 포함된 도서 검색
    List<Book> findByTitleContaining(String keyword);

    // ISBN으로 검색
    Book findByIsbn(String isbn);

    // 저자로 검색하고 출판연도 역순 정렬
    List<Book> findByAuthorOrderByPublishYearDesc(String author);

    // 출판연도 범위 검색
    List<Book> findByPublishYearBetween(int startYear, int endYear);

    // 대여 가능한 도서만 검색
    List<Book> findByAvailableTrue();
}