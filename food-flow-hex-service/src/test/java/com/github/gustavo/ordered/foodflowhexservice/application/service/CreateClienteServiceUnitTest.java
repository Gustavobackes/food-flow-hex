package com.github.gustavo.ordered.foodflowhexservice.application.service;

import com.github.gustavo.ordered.foodflowhexservice.domain.model.Cliente;
import com.github.gustavo.ordered.foodflowhexservice.domain.repository.ClienteRepository;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteRequest;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteResponse;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteUpdateRequest;
import com.github.gustavo.ordered.foodflowhexservice.exception.ClienteNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateClienteServiceUnitTest {

    @InjectMocks
    private CreateClienteService createClienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ConversionService conversionService;

    private Cliente cliente;
    private ClienteRequest clienteRequest;
    private ClienteResponse clienteResponse;

    @BeforeEach
    void setUp() {
        cliente = new Cliente(1L, "João", "joao@exemplo.com");
        clienteRequest = new ClienteRequest("João", "joao@exemplo.com");
        clienteResponse = new ClienteResponse("João", "joao@exemplo.com");
    }

    @Test
    void shouldCreateCliente() {
        when(conversionService.convert(clienteRequest, Cliente.class)).thenReturn(cliente);
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Long createdClienteId = createClienteService.createCliente(clienteRequest);

        assertNotNull(createdClienteId);
        assertEquals(1L, createdClienteId);
        verify(clienteRepository).save(cliente);
    }

    @Test
    void shouldReturnAllClientes() {
        when(clienteRepository.findAll()).thenReturn(List.of(cliente));
        when(conversionService.convert(cliente, ClienteResponse.class)).thenReturn(clienteResponse);

        List<ClienteResponse> clienteResponses = createClienteService.getAllCliente();

        assertNotNull(clienteResponses);
        assertEquals(1, clienteResponses.size());
        assertEquals(clienteResponse.getNome(), clienteResponses.get(0).getNome());
        verify(clienteRepository).findAll();
    }

    @Test
    void shouldReturnClienteById() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(conversionService.convert(cliente, ClienteResponse.class)).thenReturn(clienteResponse);

        ClienteResponse response = createClienteService.getCliente(1L);

        assertNotNull(response);
        assertEquals(clienteResponse.getNome(), response.getNome());
        verify(clienteRepository).findById(1L);
    }

    @Test
    void shouldThrowClienteNotFoundExceptionWhenClienteNotFound() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ClienteNotFoundException.class, () -> createClienteService.getCliente(1L));
    }

    @Test
    void shouldUpdateCliente() {
        ClienteUpdateRequest updateRequest = new ClienteUpdateRequest("Novo Nome", "novo@exemplo.com");
        Cliente clienteUpdated = Cliente.builder().nome(updateRequest.getNome()).email(updateRequest.getEmail()).build();
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(clienteRepository.update(cliente)).thenReturn(clienteUpdated);
        when(conversionService.convert(clienteUpdated, ClienteResponse.class))
                .thenReturn(new ClienteResponse(clienteUpdated.getNome(), clienteUpdated.getEmail()));

        ClienteResponse updatedResponse = createClienteService.updateCliente(1L, updateRequest);

        assertNotNull(updatedResponse);
        assertEquals("Novo Nome", updatedResponse.getNome());
        verify(clienteRepository).findById(1L);
        verify(clienteRepository).update(cliente);
    }

    @Test
    void shouldDeleteCliente() {
        doNothing().when(clienteRepository).deleteById(1L);

        createClienteService.deleteCliente(1L);

        verify(clienteRepository).deleteById(1L);
    }

}