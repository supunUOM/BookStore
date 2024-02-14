package lk.cba.bookstore.controller;

import lk.cba.bookstore.dto.AuthorDTO;
import lk.cba.bookstore.payload.AuthorReqPayload;
import lk.cba.bookstore.service.AuthorService;
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
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
@Slf4j
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorDTO> findAuthorById(@PathVariable("authorId") int authorId) {
        log.info("Getting author by authorId: {}", authorId);
        return new ResponseEntity<>(authorService.findAuthorById(authorId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> saveAuthor(@RequestBody AuthorReqPayload authorPayload) {
        log.info("Saving the author");
        return new ResponseEntity<>(authorService.saveAuthorWithoutBooks(authorPayload), HttpStatus.OK);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable("authorId") Integer authorId) {
        log.info("Deleting the author");
        return new ResponseEntity<>(authorService.deleteAuthor(authorId), HttpStatus.OK);
    }

}
