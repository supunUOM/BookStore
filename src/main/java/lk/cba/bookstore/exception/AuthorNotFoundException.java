package lk.cba.bookstore.exception;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 7:44 AM
 **/

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(String message) {
        super(message);
    }

    public AuthorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorNotFoundException(Throwable cause) {
        super(cause);
    }
}
