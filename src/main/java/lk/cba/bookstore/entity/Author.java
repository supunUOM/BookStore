package lk.cba.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 8:58 PM
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer authorId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL
    )
    private List<Book> books;


}
