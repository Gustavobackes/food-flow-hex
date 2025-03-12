package com.github.gustavo.ordered.foodflowhexservice.application.usecase;

import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteRequest;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteResponse;

public interface CreateClienteUseCase {
    Long createCliente(ClienteRequest clienteRequest);

    ClienteResponse getCliente(Long clienteId);

}
