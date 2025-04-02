package com.github.gustavo.ordered.foodflowhexservice.domain.repository;

import com.github.gustavo.ordered.foodflowhexservice.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Cliente save(Cliente cliente);

    Optional<Cliente> findById(Long id);

    List<Cliente> findAll();

    void deleteById(Long id);

    Cliente update(Cliente clienteUpdate);
}
