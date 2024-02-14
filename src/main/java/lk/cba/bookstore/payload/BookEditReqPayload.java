package lk.cba.bookstore.payload;

import lombok.Data;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 8:57 AM
 **/

@Data
public class BookEditReqPayload {
    private Integer bookId;
    private String isbn;
    private String title;
    private String category;
    private Integer authorId;
}
