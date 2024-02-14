package lk.cba.bookstore.service.impl;

import jakarta.transaction.Transactional;
import lk.cba.bookstore.dto.AuthorDTO;
import lk.cba.bookstore.entity.Author;
import lk.cba.bookstore.exception.AuthorAlreadyExistException;
import lk.cba.bookstore.exception.AuthorNotFoundException;
import lk.cba.bookstore.payload.AuthorReqPayload;
import lk.cba.bookstore.repository.AuthorRepository;
import lk.cba.bookstore.service.AuthorService;
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
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public AuthorDTO saveAuthorWithoutBooks(AuthorReqPayload authorPayload) {

        Optional<Author> optionalAuthor = authorRepository.findAuthorByFirstNameAndLastName(
                authorPayload.getFirstName(),
                authorPayload.getLastName()
        );

        if (optionalAuthor.isPresent()) {
            log.error("Author already exist by name: {} {}",
                    authorPayload.getFirstName(), authorPayload.getLastName());
            throw new AuthorAlreadyExistException(String.format("Author already exist by name: %s %s",
                    authorPayload.getFirstName(), authorPayload.getLastName()));
        }

        Author author = Author.builder()
                .firstName(authorPayload.getFirstName())
                .lastName(authorPayload.getLastName())
                .email(authorPayload.getEmail())
                .contactNo(authorPayload.getContactNo())
                .build();
        var savedAuthor = authorRepository.save(author);
        return modelMapperUtil.mapToDTO(savedAuthor, AuthorDTO.class);
    }

    @Override
    public AuthorDTO findAuthorById(Integer authorId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        Author author = optionalAuthor.orElseThrow(() -> {
            log.error("Author not found for id: {}", authorId);
            return new AuthorNotFoundException(String.format("Author not found for id: %s", authorId));
        });

        return modelMapperUtil.mapToDTO(author, AuthorDTO.class);
    }

    @Override
    public String deleteAuthor(Integer authorId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        optionalAuthor.orElseThrow(() -> {
            log.error("Author not found authorId: {}", authorId);
            return new AuthorNotFoundException(String.format("Author not found authorId: %d", authorId));
        });

        authorRepository.deleteById(authorId);
        return String.format("Author deleted successfully authorId: %d", authorId);
    }


}
