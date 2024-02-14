package lk.cba.bookstore.repository;

import lk.cba.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 9:46 PM
 **/

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);
}
