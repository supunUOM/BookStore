package lk.cba.bookstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
@Table(name="Book", indexes = {
        @Index(name = "idx_isbn", columnList = "isbn")
})
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Integer bookId;

    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Isbn can only contain alphanumeric characters")
    private String isbn;

    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Title can only contain alphanumeric characters")
    private String title;

    private String category;

    @Column(nullable = false)
    private int likeCount;

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
