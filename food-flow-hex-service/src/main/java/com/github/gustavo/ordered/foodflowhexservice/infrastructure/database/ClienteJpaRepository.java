package com.github.gustavo.ordered.foodflowhexservice.infrastructure.database;

import com.github.gustavo.ordered.foodflowhexservice.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<Cliente, Long> {
}
