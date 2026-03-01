package com.inhomehub.inhomehub_api.entity;

import com.inhomehub.inhomehub_api.enums.UserRoleEnum;
import com.inhomehub.inhomehub_api.enums.UserStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "usuario")
@Data
public class User {

    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(length = 255, nullable = false)
    private String fullName;

    @Column(length = 255)
    private String phone;

    @Column(length = 32, nullable = false)
    private String password;

    @Column(length = 11, nullable = false)
    private String cpf;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private UserStatusEnum status;

    @Column
    private LocalDateTime lastLogin;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private UserRoleEnum role;

    @ManyToOne
    @JoinColumn(name = "condominium_id")
    private Condominium condominium;

    @Column(nullable = true)
    private Integer apartmentNumber;
}