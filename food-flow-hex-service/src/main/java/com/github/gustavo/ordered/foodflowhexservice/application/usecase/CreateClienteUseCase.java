package com.github.gustavo.ordered.foodflowhexservice.application.usecase;

import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteRequest;

public interface CreateClienteUseCase {
    Long createCliente(ClienteRequest clienteRequest);
}
