package lk.cba.bookstore.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 10:50 PM
 **/

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
