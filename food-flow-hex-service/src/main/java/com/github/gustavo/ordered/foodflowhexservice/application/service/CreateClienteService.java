package com.github.gustavo.ordered.foodflowhexservice.application.service;

import com.github.gustavo.ordered.foodflowhexservice.application.usecase.CreateClienteUseCase;
import com.github.gustavo.ordered.foodflowhexservice.domain.model.Cliente;
import com.github.gustavo.ordered.foodflowhexservice.domain.repository.ClienteRepository;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateClienteService implements CreateClienteUseCase {

    private final ClienteRepository clienteRepository;

    private final ConversionService conversionService;

    @Override
    @Transactional
    public Long createCliente(ClienteRequest clienteRequest) {
        return clienteRepository.save(conversionService.convert(clienteRequest, Cliente.class)).getId();
    }

}
