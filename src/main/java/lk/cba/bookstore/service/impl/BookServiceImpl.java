package lk.cba.bookstore.service.impl;

import lk.cba.bookstore.dto.BookDTO;
import lk.cba.bookstore.entity.Book;
import lk.cba.bookstore.exception.BookNotFoundException;
import lk.cba.bookstore.payload.BookAuthorReqPayload;
import lk.cba.bookstore.payload.BookReqPayload;
import lk.cba.bookstore.repository.AuthorRepository;
import lk.cba.bookstore.repository.BookRepository;
import lk.cba.bookstore.service.BookService;
import lk.cba.bookstore.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 9:47 PM
 **/

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public BookDTO saveBookWithAuthor(BookAuthorReqPayload bookReq) {
        Book newBook = Book.builder()
                .isbn(bookReq.getIsbn())
                .title(bookReq.getTitle())
                .category(bookReq.getCategory())
                .author(bookReq.getAuthor())
                .build();

        Book savedBook = bookRepository.save(newBook);
        return modelMapperUtil.mapToDTO(savedBook, BookDTO.class);
    }

    @Override
    public BookDTO saveBookWithAuthorId(BookReqPayload book) {

        return null;
    }


    @Override
    public BookDTO findBookByIsbn(String isbn) {
        Optional<Book> optionalBook = bookRepository.findBookByIsbn(isbn);
        if (optionalBook.isEmpty()) {
            log.error("Book not found isbn: {}", isbn);
            throw new BookNotFoundException(String.format("Book not found isbn: %s", isbn));
        }
        //Otherwise I can use optionalBook.orElseThrow(() -> new BookNotFoundException("book not found"));
        return modelMapperUtil.mapToDTO(optionalBook.get(), BookDTO.class);
    }

    @Override
    public BookDTO editBook(BookAuthorReqPayload bookReq) {
        return null;
    }

//    public Book save(BookAuthorReqPayload bookReq) {
//        Book newBook = Book.builder()
//                .isbn(bookReq.getIsbn())
//                .title(bookReq.getTitle())
//                .category(bookReq.getCategory())
//                .author(bookReq.getAuthor())
//                .build();
//
//        return bookRepository.save(newBook);
//    }

}
