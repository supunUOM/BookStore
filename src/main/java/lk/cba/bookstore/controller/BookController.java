package lk.cba.bookstore.controller;

import lk.cba.bookstore.dto.BookDTO;
import lk.cba.bookstore.payload.BookEditReqPayload;
import lk.cba.bookstore.payload.BookReqPayload;
import lk.cba.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 9:50 PM
 **/

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDTO> getBookByIsbn(@PathVariable("isbn") String isbn) {
        log.info("try to fetching the book {} in controller", isbn);
        return new ResponseEntity<>(bookService.findBookByIsbn(isbn), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookReqPayload bookPayload) {
        log.info("try to saving the book in controller");
        return new ResponseEntity<>(bookService.saveBookWithAuthorId(bookPayload), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BookDTO> editBook(@RequestBody BookEditReqPayload bookPayload) {
        log.info("try to edit book {} in controller", bookPayload.getBookId());
        return new ResponseEntity<>(bookService.updateBook(bookPayload), HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable("isbn") String isbn) {
        log.info("try to delete book {} in controller", isbn);
        return new ResponseEntity<>(bookService.deleteBook(isbn), HttpStatus.OK);
    }

}
