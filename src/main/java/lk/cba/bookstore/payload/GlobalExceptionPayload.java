package lk.cba.bookstore.payload;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 6:20 AM
 **/

@Data
@Builder
public class GlobalExceptionPayload {
    private String errorUrl;
    private String errorMessage;
    private String timeStamp;
    private HttpStatus statusCode;
}
