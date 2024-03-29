package lk.cba.bookstore.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lk.cba.bookstore.payload.BeanInvalidExceptionPayload;
import lk.cba.bookstore.payload.GlobalExceptionPayload;
import lk.cba.bookstore.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 6:09 AM
 **/

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final CommonUtil commonUtil;

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<GlobalExceptionPayload> bookNotFound(HttpServletRequest request, BookNotFoundException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        GlobalExceptionPayload errorPayload = GlobalExceptionPayload.builder()
                .errorUrl(request.getRequestURL().toString())
                .errorMessage(exception.getMessage())
                .status(httpStatus)
                .timeStamp(commonUtil.dateFormatter(new Date()))
                .build();
        return new ResponseEntity<>(errorPayload, httpStatus);
    }

    @ExceptionHandler(BookAlreadyExistException.class)
    public ResponseEntity<GlobalExceptionPayload> bookAlreadyExist(HttpServletRequest request, BookAlreadyExistException exception) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        GlobalExceptionPayload errorPayload = GlobalExceptionPayload.builder()
                .errorUrl(request.getRequestURL().toString())
                .errorMessage(exception.getMessage())
                .status(httpStatus)
                .timeStamp(commonUtil.dateFormatter(new Date()))
                .build();
        return new ResponseEntity<>(errorPayload, httpStatus);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<GlobalExceptionPayload> authorNotFound(HttpServletRequest request, AuthorNotFoundException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        GlobalExceptionPayload errorPayload = GlobalExceptionPayload.builder()
                .errorUrl(request.getRequestURL().toString())
                .errorMessage(exception.getMessage())
                .status(httpStatus)
                .timeStamp(commonUtil.dateFormatter(new Date()))
                .build();
        return new ResponseEntity<>(errorPayload, httpStatus);
    }

    @ExceptionHandler(AuthorAlreadyExistException.class)
    public ResponseEntity<GlobalExceptionPayload> authorAlreadyExist(HttpServletRequest request, AuthorAlreadyExistException exception) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        GlobalExceptionPayload errorPayload = GlobalExceptionPayload.builder()
                .errorUrl(request.getRequestURL().toString())
                .errorMessage(exception.getMessage())
                .status(httpStatus)
                .timeStamp(commonUtil.dateFormatter(new Date()))
                .build();
        return new ResponseEntity<>(errorPayload, httpStatus);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BeanInvalidExceptionPayload> beanValidationException(HttpServletRequest request, ConstraintViolationException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        BeanInvalidExceptionPayload beanInvalidExceptionPayload = BeanInvalidExceptionPayload.builder()
                .errorMessage(exception.getMessage())
                .errorUrl(request.getRequestURL().toString())
                .status(httpStatus)
                .timeStamp(commonUtil.dateFormatter(new Date()))
                .build();
        return new ResponseEntity<>(beanInvalidExceptionPayload, httpStatus);
    }

}
