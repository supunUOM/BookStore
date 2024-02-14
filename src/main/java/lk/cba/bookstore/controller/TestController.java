package lk.cba.bookstore.controller;

import lk.cba.bookstore.entity.Author;
import lk.cba.bookstore.entity.Book;
import lk.cba.bookstore.repository.AuthorRepository;
import lk.cba.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 12:08 PM
 **/

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @GetMapping
    public Map<Author, Integer> getAuthors() {
//        List<Author> authorList = authorRepository.findAll();
//        List<Book> books = Arrays.asList(new Book());
//        List<Author> mochList = Arrays.asList(
//                new Author(1, "jdf", "sdjf", "mail.com", "45423443", books),
//                new Author(2, "jdf", "sdjf", "mail.com", "45423443", books),
//                new Author(3, "jdf", "sdjf", "mail.com", "45423443", books)
//        );
//
//        List<Integer> authIds = mochList.stream().mapToInt(Author::getAuthorId).boxed().toList();
//        for(int i =0; i< authIds.size(); i++){
//            bookRepository
//        }
//        return authorList;

        List<Book> books = bookRepository.findAll();

        Map<Author, Integer> collect = books.stream().collect(Collectors
                .groupingBy(Book::getAuthor, Collectors.summingInt(Book::getLikeCount))
        );
        return collect;
    }
}
