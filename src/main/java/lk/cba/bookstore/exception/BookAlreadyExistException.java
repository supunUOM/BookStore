package lk.cba.bookstore.exception;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 10:55 AM
 **/

public class BookAlreadyExistException extends RuntimeException{

    public BookAlreadyExistException(String message) {
        super(message);
    }

    public BookAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
