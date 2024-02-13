package lk.cba.bookstore.service;

import lk.cba.bookstore.entity.Book;
import lk.cba.bookstore.payload.BookReqPayload;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 10:06 PM
 **/

public interface BookService {
    Book savebook(BookReqPayload book);
    Book editBook(BookReqPayload book);
}