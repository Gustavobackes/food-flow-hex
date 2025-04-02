package com.github.gustavo.ordered.foodflowhexservice.infrastructure.controller;

import com.github.gustavo.ordered.foodflowhexservice.application.usecase.CreateClienteUseCase;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteRequest;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteResponse;
import com.github.gustavo.ordered.foodflowhexservice.dto.ClienteUpdateRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private final CreateClienteUseCase createClienteUseCase;


    @GetMapping("/{idCliente}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse getCliente(@PathVariable("idCliente") Long idCliente) {
        return createClienteUseCase.getCliente(idCliente);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createCliente(@RequestBody @Valid ClienteRequest clienteRequest) {
        return createClienteUseCase.createCliente(clienteRequest);
    }

    @PutMapping("/{idCliente}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse updateCliente(@PathVariable("idCliente") Long idCliente,
                                         @RequestBody @Valid ClienteUpdateRequest clienteUpdateRequest) {
        return createClienteUseCase.updateCliente(idCliente, clienteUpdateRequest);
    }

}
