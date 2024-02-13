package lk.cba.bookstore.service.impl;

import lk.cba.bookstore.entity.Book;
import lk.cba.bookstore.payload.BookReqPayload;
import lk.cba.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 9:47 PM
 **/

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    @Override
    public Book savebook(BookReqPayload book) {
        return null;
    }

    @Override
    public Book editBook(BookReqPayload book) {
        return null;
    }
}
