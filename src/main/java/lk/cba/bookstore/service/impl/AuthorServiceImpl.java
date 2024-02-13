package lk.cba.bookstore.service.impl;

import lk.cba.bookstore.repository.AuthorRepository;
import lk.cba.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 9:47 PM
 **/

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

//    public AuthorDTO saveAuthor(AuthorReqPayload author){
//
//    }

}
