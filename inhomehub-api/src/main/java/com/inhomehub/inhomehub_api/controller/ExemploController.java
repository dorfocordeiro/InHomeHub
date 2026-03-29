package com.inhomehub.inhomehub_api.controller;

import com.inhomehub.inhomehub_api.dto.ExemploDTO;
import com.inhomehub.inhomehub_api.dto.response.ExemploResponseDTO;
import com.inhomehub.inhomehub_api.exception.UserException;
import com.inhomehub.inhomehub_api.service.ExemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exemplo")
public class ExemploController {

    @Autowired
    private ExemploService exemploService;

    @PostMapping("criar")
    public ResponseEntity<?> criarExemplo(@RequestBody ExemploDTO exemploDTO){
        try {
            ExemploResponseDTO response = exemploService.criarExemplo(exemploDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            // Exemplo de erro de validação
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Erro inesperado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar exemplo: " + e.getMessage());
        }
    }


    @GetMapping("listar")
    public List<ExemploResponseDTO> listarTodos(){
        return exemploService.listarTodos();
    }

    @GetMapping("listar/{nome}")
    public ResponseEntity<?> listarExemplo(@PathVariable String nome) {
        List<ExemploResponseDTO> lista = exemploService.listarExemplo(nome);
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum exemplo encontrado com o nome: " + nome);
        }
        return ResponseEntity.ok(lista);
    }



}
