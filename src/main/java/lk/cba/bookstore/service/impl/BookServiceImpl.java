package lk.cba.bookstore.service.impl;

import jakarta.transaction.Transactional;
import lk.cba.bookstore.dto.BookDTO;
import lk.cba.bookstore.entity.Author;
import lk.cba.bookstore.entity.Book;
import lk.cba.bookstore.exception.AuthorNotFoundException;
import lk.cba.bookstore.exception.BookAlreadyExistException;
import lk.cba.bookstore.exception.BookNotFoundException;
import lk.cba.bookstore.payload.BookEditReqPayload;
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
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public BookDTO saveBookWithAuthorId(BookReqPayload book) {
        if (book.getAuthorId() == null) {
            log.error("Author id can't be null when saving the book");
            throw new IllegalArgumentException("Author id is null");
        }

        Optional<Author> optionalAuthor = authorRepository.findById(book.getAuthorId());
        Optional<Book> optionalBook = bookRepository.findBookByIsbn(book.getIsbn());

        if (optionalBook.isPresent()) {
            log.error("Book is already exist isbn: {}", book.getIsbn());
            throw new BookAlreadyExistException(String.format("Book already exist isbn: %s", book.getIsbn()));
        }

        Author fetchedAuthor = optionalAuthor.orElseThrow(() -> {
            log.error("Author not found when saving the book");
            return new AuthorNotFoundException(String.format("Author not found authorId: %s", book.getAuthorId()));
        });

        Book newBook = Book.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .category(book.getCategory())
                .author(fetchedAuthor)
                .build();

        var savedBook = bookRepository.save(newBook);

        return modelMapperUtil.mapToDTO(savedBook, BookDTO.class);
    }


    @Override
    public BookDTO findBookByIsbn(String isbn) {
        Optional<Book> optionalBook = bookRepository.findBookByIsbn(isbn);
        if (optionalBook.isEmpty()) {
            log.error("Book not found isbn: {}", isbn);
            throw new BookNotFoundException(String.format("Book not found isbn: %s", isbn));
        }
        return modelMapperUtil.mapToDTO(optionalBook.get(), BookDTO.class);
    }

    @Override
    public BookDTO updateBook(BookEditReqPayload bookReq) {
        if (bookReq.getBookId() == null) {
            throw new IllegalArgumentException("Book id cannot be null.");
        }
        var optionalBook = bookRepository.findById(bookReq.getBookId());
        Book book = optionalBook.orElseThrow(() -> {
            log.error("Book not found when editing.");
            return new BookNotFoundException("Book not found when editing.");
        });
        book.setIsbn(book.getIsbn());
        book.setTitle(bookReq.getTitle());
        book.setCategory(bookReq.getCategory());

        if (bookReq.getAuthorId() != null && book.getAuthor().getAuthorId() != bookReq.getAuthorId()) {
            Optional<Author> optionalAuthor = authorRepository.findById(bookReq.getAuthorId());
            Author fetchedAuthor = optionalAuthor.orElseThrow(() -> {
                log.error("Author not found for id: {}", bookReq.getAuthorId());
                return new AuthorNotFoundException("Author not found");
            });
            book.setAuthor(fetchedAuthor);
            log.info("New author set for book id: {}", bookReq.getBookId());
        }

        Book savedBook = bookRepository.save(book);

        return modelMapperUtil.mapToDTO(savedBook, BookDTO.class);
    }

    @Override
    public String deleteBook(String isbn) {
        Optional<Book> optionalBook = bookRepository.findBookByIsbn(isbn);
        if (optionalBook.isEmpty()) {
            log.error("Non existing book cannot be deleted, isbn: {}", isbn);
            throw new BookNotFoundException("Book now found when deleting.");
        }
        bookRepository.deleteBookByIsbn(isbn);
        return String.format("Book deleted successfully isbn: %s", isbn);
    }

}
