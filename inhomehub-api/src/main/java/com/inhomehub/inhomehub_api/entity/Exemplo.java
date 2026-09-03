package com.inhomehub.inhomehub_api.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Exemplo {

    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 255)
    private String nome;

    @Column(name = "flg_excluida", nullable = false)
    private boolean excluida;
}
