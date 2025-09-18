package com.example.LaGranjaSA.resolver;

import com.example.LaGranjaSA.modelo.Alimentacion;
import com.example.LaGranjaSA.modelo.Raza;
import com.example.LaGranjaSA.servicio.AlimentacionServicio;
import com.example.LaGranjaSA.servicio.RazaServicio; // Nuevo import
import com.example.LaGranjaSA.input.AlimentacionInput;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AlimentacionResolver {

    private final AlimentacionServicio alimentacionServicio;
    private final RazaServicio razaServicio; // Nuevo atributo

    public AlimentacionResolver(AlimentacionServicio alimentacionServicio, RazaServicio razaServicio) {
        this.alimentacionServicio = alimentacionServicio;
        this.razaServicio = razaServicio; // Inicializar el servicio
    }

    // Queries
    @QueryMapping
    public List<Alimentacion> getAlimentaciones() {
        return alimentacionServicio.getAlimentos();
    }

    @QueryMapping
    public Alimentacion getAlimentacionById(@Argument int id) {
        return alimentacionServicio.findById(id);
    }

    // Mutations
    @MutationMapping
    public Alimentacion saveAlimentacion(@Argument AlimentacionInput alimentacionInput) {
        // Buscar la entidad de Raza usando el ID del input
        Raza raza = razaServicio.findById(alimentacionInput.raza().idRaza());

        // Validar que la entidad existe
        if (raza == null) {
            throw new RuntimeException("Raza no encontrada.");
        }

        Alimentacion alimentacion = new Alimentacion(
            Integer.parseInt(alimentacionInput.id()),
            raza, // Pasar la entidad Raza completa
            alimentacionInput.etapa(),
            alimentacionInput.descripcion(),
            alimentacionInput.dosis()
        );
        return alimentacionServicio.saveAlimentacion(alimentacion);
    }

    @MutationMapping
    public Boolean deleteAlimentacion(@Argument int id) {
        alimentacionServicio.deleteById(id);
        return true;
    }
}