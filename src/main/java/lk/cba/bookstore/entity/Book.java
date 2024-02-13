package lk.cba.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 8:50 PM
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Integer bookId;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    private String category;

    private Integer likeCount;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "authorId",
            nullable = false
    )
    private Author author;

}
