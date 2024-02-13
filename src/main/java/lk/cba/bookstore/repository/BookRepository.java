package lk.cba.bookstore.repository;

import lk.cba.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 9:45 PM
 **/

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
