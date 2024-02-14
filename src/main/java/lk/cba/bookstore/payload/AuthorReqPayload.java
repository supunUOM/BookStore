package lk.cba.bookstore.payload;

import lk.cba.bookstore.entity.Book;
import lombok.Data;

import java.util.List;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 9:59 PM
 **/

@Data
public class AuthorReqPayload {
    private String firstName;
    private String lastName;
    private String email;
    private List<Book> books;
}
