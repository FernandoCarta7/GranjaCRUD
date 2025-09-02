package com.example.LaGranjaSA.repositorio;

import com.example.LaGranjaSA.modelo.Alimentacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepositorio extends JpaRepository<Alimentacion, Integer> {
}
