package com.github.gustavo.ordered.foodflowhexservice.converter;

import com.github.gustavo.ordered.foodflowhexservice.domain.model.Cliente;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.extensions.spring.AdapterMethodName;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
@AdapterMethodName("convert")
public interface ClienteRequestToClienteConverter extends Converter<ClienteRequest, Cliente> {

    @Override
    Cliente convert(ClienteRequest source);

}
