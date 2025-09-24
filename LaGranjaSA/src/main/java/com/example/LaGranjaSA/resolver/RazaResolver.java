package com.example.LaGranjaSA.resolver;

import com.example.LaGranjaSA.modelo.Alimentacion;
import com.example.LaGranjaSA.modelo.Raza;
import com.example.LaGranjaSA.servicio.RazaServicio;
import com.example.LaGranjaSA.input.RazaInput;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RazaResolver {

    private final RazaServicio razaServicio;

    public RazaResolver(RazaServicio razaServicio) {
        this.razaServicio = razaServicio;
    }

    @QueryMapping
    public List<Raza> getRazas() {
        return razaServicio.getRazas();
    }

    @QueryMapping
    public Raza getRazaByDescripcion(@Argument String descripcion) {
        return razaServicio.findByDescripcion(descripcion);
    }

    @QueryMapping
    public Raza getRazaById(@Argument String idRaza) {
        return razaServicio.findById(idRaza);
    }

    //saveRaza
    @MutationMapping
    public Raza saveRaza(@Argument RazaInput raza) {
        Raza nuevaRaza = new Raza();
        //nuevaRaza.setIdRaza(Integer.parseInt(raza.idRaza()));
        nuevaRaza.setDescripcion(raza.descripcion());
        
        return razaServicio.saveRaza(nuevaRaza);
    }

    @MutationMapping
    public Raza updateRaza(@Argument String idRaza, @Argument RazaInput raza) {
        Raza razaExistente = razaServicio.findById(idRaza);
        if (razaExistente == null) {
            throw new RuntimeException("Raza no encontrada con el ID: " + idRaza);
        }

        // Actualizar el campo de descripción
        if (raza.descripcion() != null) {
            razaExistente.setDescripcion(raza.descripcion());
        }
        
        return razaServicio.saveRaza(razaExistente);
    }

    //deleteRaza
    @MutationMapping
    public Boolean deleteRaza(@Argument String idRaza) {
        Raza raza = razaServicio.findById(idRaza);
        if (raza != null) {
            // Assuming you have a method in RazaServicio to delete by ID
            razaServicio.deleteById(Integer.parseInt(idRaza));
            return true;
        }
        return false;
    }
}