package com.example.LaGranjaSA.repositorio;

import com.example.LaGranjaSA.modelo.Porcino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PorcinoRepositorio extends JpaRepository<Porcino, Integer> {
    @Transactional
    void deleteByCliente_Cedula(String cedula);
    @Transactional
    List<Porcino> findByClienteCedula(String cedula);
}
