package lk.cba.bookstore.exception;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 9:14 AM
 **/

public class AuthorAlreadyExistException extends RuntimeException{
    public AuthorAlreadyExistException(String message) {
        super(message);
    }

    public AuthorAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
