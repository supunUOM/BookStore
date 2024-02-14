package lk.cba.bookstore.exception;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 6:14 AM
 **/

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
