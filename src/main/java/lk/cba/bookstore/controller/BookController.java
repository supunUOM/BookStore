package lk.cba.bookstore.controller;

import lk.cba.bookstore.dto.BookDTO;
import lk.cba.bookstore.payload.BookAuthorReqPayload;
import lk.cba.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
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
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookAuthorReqPayload bookAuthorReqPayload) {
        var book = bookService.saveBookWithAuthor(bookAuthorReqPayload);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDTO> getBookByIsbn(@PathVariable("isbn") String isbn) {
        BookDTO bookDTO = bookService.findBookByIsbn(isbn);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }
}
