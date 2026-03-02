package com.inhomehub.inhomehub_api.controller;

import com.inhomehub.inhomehub_api.dto.ExemploDTO;
import com.inhomehub.inhomehub_api.dto.response.ExemploResponseDTO;
import com.inhomehub.inhomehub_api.service.ExemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/exemplo")
public class ExemploController {

    @Autowired
    private ExemploService exemploService;

    @PostMapping("criar")
    public ExemploResponseDTO criarExemplo(@RequestBody ExemploDTO exemploDTO){
        return exemploService.criarExemplo(exemploDTO);
    }


}
