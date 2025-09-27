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
    public List<Alimentacion> getAlimentacion() {
        var lista = alimentacionServicio.getAlimentos();
        return lista ;
    }

    @QueryMapping
    public Alimentacion getAlimentacionById(@Argument int id_alimentacion) {
        return alimentacionServicio.findById(id_alimentacion);
    }

    // Mutations
    @MutationMapping
    public Alimentacion saveAlimentacion(@Argument AlimentacionInput alimentacion) {
        // Buscar la entidad de Raza usando el ID del input
        Raza raza = razaServicio.findById(alimentacion.raza().idRaza());

        // Validar que la entidad existe
        if (raza == null) {
            throw new RuntimeException("Raza no encontrada.");
        }

        Alimentacion nuevaAlimentacion = new Alimentacion();
        nuevaAlimentacion.setRaza(raza);
        nuevaAlimentacion.setEtapa(alimentacion.etapa());
        nuevaAlimentacion.setDescripcion(alimentacion.descripcion());
        nuevaAlimentacion.setDosis(alimentacion.dosis());

        return alimentacionServicio.saveAlimentacion(nuevaAlimentacion);
    }

    @MutationMapping
    public Alimentacion updateAlimentacion(@Argument int id_alimentacion, @Argument AlimentacionInput alimentacion) {
        Alimentacion alimentacionExistente = alimentacionServicio.findById(id_alimentacion);
        if (alimentacionExistente == null) {
            throw new RuntimeException("Alimentacion no encontrada con el ID: " + id_alimentacion);
        }

        // Actualizar los campos de la alimentación
        if (alimentacion.etapa() != null) {
            alimentacionExistente.setEtapa(alimentacion.etapa());
        }
        if (alimentacion.descripcion() != null) {
            alimentacionExistente.setDescripcion(alimentacion.descripcion());
        }
        if (alimentacion.dosis() != 0.0f) {
            alimentacionExistente.setDosis(alimentacion.dosis());
        }
        
        // Actualizar la entidad Raza si se proporciona
        if (alimentacion.raza() != null && alimentacion.raza().idRaza() != null) {
            Raza raza = razaServicio.findById(alimentacion.raza().idRaza());
            if (raza == null) {
                throw new RuntimeException("Raza no encontrada.");
            }
            alimentacionExistente.setRaza(raza);
        }

        return alimentacionServicio.saveAlimentacion(alimentacionExistente);
    }

    @MutationMapping
    public Boolean deleteAlimentacion(@Argument int id_alimentacion) {
        alimentacionServicio.deleteById(id_alimentacion);
        return true;
    }
}