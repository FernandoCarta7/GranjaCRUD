package com.example.LaGranjaSA.resolver;

import com.example.LaGranjaSA.modelo.Raza;
import com.example.LaGranjaSA.servicio.RazaServicio;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RazaResolver {

    private final RazaServicio razaServicio;

    public RazaResolver(RazaServicio razaServicio) {
        this.razaServicio = razaServicio;
    }
    
    // Queries
    @QueryMapping
    public Raza getRazaByDescription(@Argument String descripcion) {
        return razaServicio.findByDescripcion(descripcion);
    }
}