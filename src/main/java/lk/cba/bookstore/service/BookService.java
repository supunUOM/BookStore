package lk.cba.bookstore.service;

import lk.cba.bookstore.dto.BookDTO;
import lk.cba.bookstore.payload.BookEditReqPayload;
import lk.cba.bookstore.payload.BookReqPayload;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 10:06 PM
 **/

public interface BookService {

    BookDTO saveBookWithAuthorId(BookReqPayload book);

    BookDTO findBookByIsbn(String isbn);

    BookDTO updateBook(BookEditReqPayload book);

    String deleteBook(String isbn);

}
