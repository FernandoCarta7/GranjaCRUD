package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Alimentacion;
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

    public java.util.List<Raza> getRazas() {
        return repositorio.findAll();
    }

    public Raza saveRaza(Raza raza) {
        return repositorio.save(raza);
    }

    public void deleteById(int idRaza) {
        Raza raza = repositorio.findById(idRaza).orElse(null);
        if (raza != null) repositorio.deleteById(idRaza);
    }
}