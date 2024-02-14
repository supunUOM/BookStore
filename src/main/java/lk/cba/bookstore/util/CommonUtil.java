package lk.cba.bookstore.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: supun
 * @Created_at: 14/02/2024
 * @Time: 6:31 AM
 **/

@Component
public class CommonUtil {
    public String dateFormatter(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
