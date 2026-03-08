package com.inhomehub.inhomehub_api.repository;

import com.inhomehub.inhomehub_api.entity.Exemplo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExemploRepository extends JpaRepository<Exemplo, UUID> {
    Optional<Exemplo> findByNome(String nome);

    List<Exemplo> findByNomeContainingIgnoreCase(String nome);
}