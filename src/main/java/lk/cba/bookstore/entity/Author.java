package lk.cba.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name can only contain letters")
    private String firstName;

    @Column(nullable = false)
    @Pattern(regexp = "^[A-Za-z]+$", message = "Last name can only contain letters")
    private String lastName;

    @Column(nullable = false)
    @Email(message = "invalid email address")
    private String email;

    @Column(nullable = false)
    private String contactNo;

    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Book> books;


}
