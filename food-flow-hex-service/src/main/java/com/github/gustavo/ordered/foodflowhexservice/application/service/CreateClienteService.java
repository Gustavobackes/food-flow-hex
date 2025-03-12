package com.github.gustavo.ordered.foodflowhexservice.application.service;

import com.github.gustavo.ordered.foodflowhexservice.application.usecase.CreateClienteUseCase;
import com.github.gustavo.ordered.foodflowhexservice.domain.model.Cliente;
import com.github.gustavo.ordered.foodflowhexservice.domain.repository.ClienteRepository;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteRequest;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteResponse;
import com.github.gustavo.ordered.foodflowhexservice.exception.ClienteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(readOnly = true)
    public ClienteResponse getCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new ClienteNotFoundException("Cliente não encontrado"));
        return conversionService.convert(cliente, ClienteResponse.class);
    }

}
