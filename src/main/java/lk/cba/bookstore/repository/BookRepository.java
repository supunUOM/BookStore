package lk.cba.bookstore.repository;

import lk.cba.bookstore.entity.Author;
import lk.cba.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 9:45 PM
 **/

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findBookByIsbn(String isbn);

    Optional<List<Book>> findBooksByAuthor(Author author);

    void deleteBookByIsbn(String isbn);
}
