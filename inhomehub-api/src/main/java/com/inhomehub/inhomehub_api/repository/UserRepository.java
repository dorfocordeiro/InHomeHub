package com.inhomehub.inhomehub_api.repository;


import com.inhomehub.inhomehub_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
