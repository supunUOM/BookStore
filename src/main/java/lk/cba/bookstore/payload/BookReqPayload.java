package lk.cba.bookstore.payload;

import lombok.Data;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 7:41 AM
 **/

@Data
public class BookReqPayload {
    private String isbn;
    private String title;
    private String category;
    private Integer authorId;
}
