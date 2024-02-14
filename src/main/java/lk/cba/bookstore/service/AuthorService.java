package lk.cba.bookstore.service;

import lk.cba.bookstore.dto.AuthorDTO;
import lk.cba.bookstore.payload.AuthorReqPayload;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 10:06 PM
 **/

public interface AuthorService {
    AuthorDTO saveAuthorWithoutBooks(AuthorReqPayload authorPayload);
    AuthorDTO findAuthorById(Integer authorId);
}
