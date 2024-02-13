package lk.cba.bookstore.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: supun
 * @Created_at: 13/02/2024
 * @Time: 10:52 PM
 **/

@Component
@RequiredArgsConstructor
public class ModalMapperUtil {

    private final ModelMapper modelMapper;

    public <S, T> List<T> mapToDTOList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <S, T> T mapToDTO(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

}
