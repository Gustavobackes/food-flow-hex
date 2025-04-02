package com.github.gustavo.ordered.foodflowhexservice.application.usecase;

import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteRequest;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteResponse;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteUpdateRequest;
import jakarta.validation.Valid;

public interface CreateClienteUseCase {
    Long createCliente(ClienteRequest clienteRequest);

    ClienteResponse getCliente(Long clienteId);

    ClienteResponse updateCliente(Long idCliente, @Valid ClienteUpdateRequest clienteUpdateRequest);
}
