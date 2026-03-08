package com.inhomehub.inhomehub_api.service;

import com.inhomehub.inhomehub_api.dto.ExemploDTO;
import com.inhomehub.inhomehub_api.dto.response.ExemploResponseDTO;
import com.inhomehub.inhomehub_api.entity.Exemplo;
import com.inhomehub.inhomehub_api.repository.ExemploRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExemploService {

    @Autowired
    private ExemploRepository exemploRepository;

    public ExemploResponseDTO criarExemplo(ExemploDTO exemploDTO) {
        if (exemploDTO.nome() == null || exemploDTO.nome().isEmpty()) {
            throw new IllegalArgumentException("O nome do exemplo não pode ser nulo ou vazio.");
        }

        if (exemploRepository.findByNome(exemploDTO.nome()).isPresent()) {
            throw new IllegalArgumentException("Já existe um exemplo com o nome: " + exemploDTO.nome());
        }
        Exemplo exemplo = new Exemplo();
        exemplo.setNome(exemploDTO.nome());
        exemplo.setId(UUID.randomUUID());
        exemploRepository.save(exemplo);
        return new ExemploResponseDTO(exemplo.getId(), exemplo.getNome());
    }

    public List<ExemploResponseDTO> listarTodos(){
        List<Exemplo> exemplos = exemploRepository.findAll();
        return exemplos.stream()
                .map(exemplo -> new ExemploResponseDTO(exemplo.getId(), exemplo.getNome()))
                .toList();
    }

    public List<ExemploResponseDTO> listarExemplo(String nome){
        List<Exemplo> exemplos = exemploRepository.findByNomeContainingIgnoreCase(nome);
        return exemplos.stream()
                .map(exemplo -> new ExemploResponseDTO(exemplo.getId(), exemplo.getNome()))
                .toList();
    }

}
