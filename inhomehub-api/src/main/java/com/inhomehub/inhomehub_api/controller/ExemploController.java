package com.inhomehub.inhomehub_api.controller;

import com.inhomehub.inhomehub_api.dto.ExemploDTO;
import com.inhomehub.inhomehub_api.dto.response.ExemploResponseDTO;
import com.inhomehub.inhomehub_api.service.ExemploService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exemplo")
public class ExemploController {

    @Autowired
    private ExemploService exemploService;

    @PostMapping("criar")
    public ExemploResponseDTO criarExemplo(@RequestBody ExemploDTO exemploDTO){
        return exemploService.criarExemplo(exemploDTO);
    }


    @GetMapping("listar")
    public List<ExemploResponseDTO> listarTodos(){
        return exemploService.listarTodos();
    }

    @GetMapping("listar/{nome}")
    public List<ExemploResponseDTO> listarExemplo(@PathVariable String nome) {
        return exemploService.listarExemplo(nome);
    }



}
