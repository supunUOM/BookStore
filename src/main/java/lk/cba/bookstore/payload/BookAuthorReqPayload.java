package lk.cba.bookstore.payload;

import lk.cba.bookstore.entity.Author;
import lombok.Data;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 10:09 PM
 **/


@Data
public class BookAuthorReqPayload {
    private String isbn;
    private String title;
    private String category;
    private Author author;
}
