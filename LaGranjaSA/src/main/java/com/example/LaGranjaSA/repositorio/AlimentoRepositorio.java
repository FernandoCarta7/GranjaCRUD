package com.example.LaGranjaSA.repositorio;

import com.example.LaGranjaSA.modelo.Alimentacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentoRepositorio extends JpaRepository<Alimentacion, Integer> {
    List<Alimentacion> findByRaza_IdRaza(int idRaza);

}
