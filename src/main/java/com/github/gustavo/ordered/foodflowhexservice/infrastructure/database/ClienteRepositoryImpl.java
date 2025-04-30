package com.github.gustavo.ordered.foodflowhexservice.infrastructure.database;

import com.github.gustavo.ordered.foodflowhexservice.domain.model.Cliente;
import com.github.gustavo.ordered.foodflowhexservice.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteJpaRepository clienteJpaRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteJpaRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteJpaRepository.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteJpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        clienteJpaRepository.deleteById(id);
    }

    @Override
    public Cliente update(Cliente clienteUpdate) {
        return clienteJpaRepository.save(clienteUpdate);
    }

}
