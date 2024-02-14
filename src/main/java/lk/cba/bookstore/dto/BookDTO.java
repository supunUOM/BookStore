package lk.cba.bookstore.dto;

import lk.cba.bookstore.entity.Author;
import lombok.*;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 11:16 PM
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private Integer bookId;
    private String isbn;
    private String title;
    private String category;
    private Author author;
}
