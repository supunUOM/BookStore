package lk.cba.bookstore.service;

import lk.cba.bookstore.entity.Book;
import lk.cba.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 11:44 AM
 **/

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {

    private final BookRepository bookRepository;

    //    @Scheduled(fixedRate = 300_000L)
    @Scheduled(fixedRate = 3000L)
    public void likeCountLoggerJob() {
        List<Book> bookList = bookRepository.findAll();

        Map<String, Integer> result = bookList.stream().collect(Collectors
                .groupingBy(book -> String.format("%s %s", book.getAuthor().getFirstName(), book.getAuthor().getLastName()),
                        Collectors.summingInt(Book::getLikeCount)));

        log.info("Author and relevant like count: {}", result);
    }
}
