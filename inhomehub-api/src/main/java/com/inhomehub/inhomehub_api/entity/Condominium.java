package com.inhomehub.inhomehub_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "condominio")
@Data
public class Condominium {

    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @Column(length = 100)
    private String email;

    @Column(length = 15)
    private String phone;

    @Column(length = 255)
    private String website;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
}