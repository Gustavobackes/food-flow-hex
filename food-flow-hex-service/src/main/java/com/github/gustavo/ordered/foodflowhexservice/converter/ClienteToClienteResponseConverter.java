package com.github.gustavo.ordered.foodflowhexservice.converter;

import com.github.gustavo.ordered.foodflowhexservice.domain.model.Cliente;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.extensions.spring.AdapterMethodName;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
@AdapterMethodName("convert")
public interface ClienteToClienteResponseConverter extends Converter<Cliente, ClienteResponse> {

    @Override
    ClienteResponse convert(Cliente source);

}
