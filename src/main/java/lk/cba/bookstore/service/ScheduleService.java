package lk.cba.bookstore.service;

import lk.cba.bookstore.entity.Author;
import lk.cba.bookstore.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 11:44 AM
 **/

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {

    private final AuthorRepository authorRepository;

    //    @Scheduled(fixedRate = 300_000L)
//    @Scheduled(fixedRate = 3000L)
//    public void likeCountLoggerJob() {
////        log.info("========+++++++");
//        List<Author> authorList = authorRepository.findAll();
//        System.out.println(authorList);
//    }
}
