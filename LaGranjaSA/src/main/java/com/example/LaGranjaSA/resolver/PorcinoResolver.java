package com.example.LaGranjaSA.resolver;

import com.example.LaGranjaSA.modelo.Porcino;
import com.example.LaGranjaSA.modelo.Cliente;
import com.example.LaGranjaSA.modelo.Raza;
import com.example.LaGranjaSA.servicio.PorcinoServicio;
import com.example.LaGranjaSA.servicio.ClienteServicio;
import com.example.LaGranjaSA.servicio.RazaServicio;
import com.example.LaGranjaSA.input.PorcinoInput;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PorcinoResolver {

    private final PorcinoServicio porcinoServicio;
    private final ClienteServicio clienteServicio;
    private final RazaServicio razaServicio;

    public PorcinoResolver(PorcinoServicio porcinoServicio, ClienteServicio clienteServicio, RazaServicio razaServicio) {
        this.porcinoServicio = porcinoServicio;
        this.clienteServicio = clienteServicio;
        this.razaServicio = razaServicio;
    }

    // Queries
    @QueryMapping
    public List<Porcino> getPorcinos() {
        return porcinoServicio.getPorcinos();
    }

    @QueryMapping
    public Porcino getPorcinoById(@Argument String id_porcino) {
        int id = Integer.parseInt(id_porcino);
        return porcinoServicio.getPorcinoById(id);
    }

    // Mutations
    @MutationMapping
    public Porcino savePorcino(@Argument PorcinoInput porcino) {
        // 1. Fetch the full Cliente entity using the ID from the input
        Cliente cliente = clienteServicio.findClienteById(porcino.cliente().cedula());

        // 2. Fetch the full Raza entity using the ID from the input
        Raza raza = razaServicio.findById(porcino.raza().idRaza());

        // Optional: Add validation to ensure entities were found
        if (cliente == null || raza == null) {
            throw new RuntimeException("Cliente or Raza not found.");
        }

        // 3. Create the Porcino entity with the fetched objects
        Porcino nuevoPorcino = new Porcino();
        //porcino.setId_porcino(Integer.parseInt(porcinoInput.id_porcino()));
        nuevoPorcino.setFecha_nacimiento(LocalDate.parse(porcino.fecha_nacimiento()));
        nuevoPorcino.setPeso(porcino.peso());
        nuevoPorcino.setCliente(cliente);
        nuevoPorcino.setRaza(raza);

        // Calcular edad automáticamente después de establecer fecha_nacimiento
        nuevoPorcino.setEdad(nuevoPorcino.calcularEdad());

        // 4. Save the Porcino entity
        return porcinoServicio.savePorcino(nuevoPorcino);
    }

    @MutationMapping
    public Porcino updatePorcino(@Argument String id_porcino, @Argument PorcinoInput porcino) {
        int id = Integer.parseInt(id_porcino);
        Porcino porcinoExistente = porcinoServicio.getPorcinoById(id);
        if (porcinoExistente == null) {
            throw new RuntimeException("Porcino no encontrado con el ID: " + id_porcino);
        }
        
        // Actualizar los campos del porcino
        if (porcino.fecha_nacimiento() != null) {
            porcinoExistente.setFecha_nacimiento(LocalDate.parse(porcino.fecha_nacimiento()));
            // Recalcular la edad si la fecha de nacimiento ha cambiado
            porcinoExistente.setEdad(porcinoExistente.calcularEdad());
        }
        if (porcino.peso() != 0.0f) {
            porcinoExistente.setPeso(porcino.peso());
        }
        
        // Actualizar las entidades relacionadas si se proporcionan
        if (porcino.cliente() != null && porcino.cliente().cedula() != null) {
            Cliente cliente = clienteServicio.findClienteById(porcino.cliente().cedula());
            if (cliente == null) {
                throw new RuntimeException("Cliente no encontrado.");
            }
            porcinoExistente.setCliente(cliente);
        }
        if (porcino.raza() != null && porcino.raza().idRaza() != null) {
            Raza raza = razaServicio.findById(porcino.raza().idRaza());
            if (raza == null) {
                throw new RuntimeException("Raza no encontrada.");
            }
            porcinoExistente.setRaza(raza);
        }

        return porcinoServicio.savePorcino(porcinoExistente);
    }

    @MutationMapping
    public Boolean deletePorcino(@Argument String id_porcino) {
        int id = Integer.parseInt(id_porcino);
        porcinoServicio.deletePorcinoById(id);
        return true;
    }
}