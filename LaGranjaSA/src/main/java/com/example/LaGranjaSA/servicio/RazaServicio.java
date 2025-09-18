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

    // Cambia el tipo de 'id' de int a String
    public Raza findById(String id) {
        try {
            int intId = Integer.parseInt(id);
            return repositorio.findById(intId).orElse(null);
        } catch (NumberFormatException e) {
            // Maneja el caso si el ID no es un número válido
            return null;
        }
    }
}