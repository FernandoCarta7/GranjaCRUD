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
    public Porcino savePorcino(@Argument PorcinoInput porcinoInput) {
        // 1. Fetch the full Cliente entity using the ID from the input
        Cliente cliente = clienteServicio.findClienteById(porcinoInput.cliente().cedula());

        // 2. Fetch the full Raza entity using the ID from the input
        Raza raza = razaServicio.findById(porcinoInput.raza().idRaza());

        // Optional: Add validation to ensure entities were found
        if (cliente == null || raza == null) {
            throw new RuntimeException("Cliente or Raza not found.");
        }

        // 3. Create the Porcino entity with the fetched objects
        Porcino porcino = new Porcino();
        porcino.setId_porcino(Integer.parseInt(porcinoInput.id_porcino()));
        porcino.setFecha_nacimiento(LocalDate.parse(porcinoInput.fecha_nacimiento()));
        porcino.setPeso(porcinoInput.peso());
        porcino.setCliente(cliente);
        porcino.setRaza(raza);

        // 4. Save the Porcino entity
        return porcinoServicio.savePorcino(porcino);
    }

    @MutationMapping
    public Boolean deletePorcino(@Argument String id_porcino) {
        int id = Integer.parseInt(id_porcino);
        porcinoServicio.deletePorcinoById(id);
        return true;
    }
}