package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Raza;
import com.example.LaGranjaSA.repositorio.RazaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazaServicio {
    @Autowired
    private RazaRepositorio repositorio;

    public Raza findByDescripcion(String descripcion) {
        return repositorio.findByDescripcion(descripcion);
    }
}
