package lk.cba.bookstore.dto;

import lk.cba.bookstore.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 10:00 PM
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDTO {
    private Integer authorId;
    private String firstName;
    private String lastName;
    private String email;
    private List<Book> books;
}
