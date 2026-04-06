package com.inhomehub.inhomehub_api.controller;

import com.inhomehub.inhomehub_api.dto.ExemploDTO;
import com.inhomehub.inhomehub_api.dto.response.ExemploResponseDTO;
import com.inhomehub.inhomehub_api.exception.UserException;
import com.inhomehub.inhomehub_api.service.ExemploService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/exemplo")
public class ExemploController {

    private ExemploService exemploService;

    @PostMapping("criar")
    public ResponseEntity<ExemploResponseDTO> criarExemplo(@RequestBody ExemploDTO exemploDTO) {
        ExemploResponseDTO response = exemploService.criarExemplo(exemploDTO);
        return ResponseEntity.ok(response);
    }


    @GetMapping("listar")
    public List<ExemploResponseDTO> listarTodos(){
        return exemploService.listarTodos();
    }

    @GetMapping("listar/{nome}")
    public ResponseEntity<ExemploResponseDTO> listarExemplo(@PathVariable String nome) {
        ExemploResponseDTO lista = exemploService.listarExemplo(nome);
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("excluir/{nome}")
    public ResponseEntity<ExemploResponseDTO> excluir(@PathVariable String nome) {
        exemploService.excluir(nome);
        return ResponseEntity.ok(new ExemploResponseDTO(null, "Exemplo " + nome + " excluído com sucesso."));
    }

}
