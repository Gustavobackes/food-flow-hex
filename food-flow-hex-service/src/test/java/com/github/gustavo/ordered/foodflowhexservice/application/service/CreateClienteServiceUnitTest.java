package com.github.gustavo.ordered.foodflowhexservice.application.service;

import com.github.gustavo.ordered.foodflowhexservice.converter.ClienteRequestToClienteConverter;
import com.github.gustavo.ordered.foodflowhexservice.domain.model.Cliente;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateClienteServiceUnitTest {

    private CreateClienteService createClienteService;

    private ClienteRequestToClienteConverter converter;

    @Test
    void shouldCreateCliente() {
    }

}