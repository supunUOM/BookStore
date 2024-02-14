package lk.cba.bookstore.payload;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 2:58 PM
 **/

@Data
@Builder
public class BeanInvalidExceptionPayload {
    private String errorUrl;
    private Map<String, String> beanErrors;
    private String errorMessage;
    private String timeStamp;
    private HttpStatus status;
}
