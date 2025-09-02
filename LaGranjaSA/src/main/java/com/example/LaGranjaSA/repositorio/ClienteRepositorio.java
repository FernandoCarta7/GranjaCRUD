package com.example.LaGranjaSA.repositorio;

import com.example.LaGranjaSA.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, String> {
}
