package com.example.LaGranjaSA.resolver;

import com.example.LaGranjaSA.modelo.Cliente;
import com.example.LaGranjaSA.servicio.ClienteServicio;
import com.example.LaGranjaSA.input.ClienteInput; // Importar la clase ClienteInput
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClienteResolver {

    private final ClienteServicio clienteServicio;

    public ClienteResolver(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    // Queries
    @QueryMapping
    public List<Cliente> getClientes() {
        return clienteServicio.getClientes();
    }

    @QueryMapping
    public Cliente getClienteById(@Argument String cedula) {
        return clienteServicio.findClienteById(cedula);
    }

    // Mutations
    @MutationMapping
    public Cliente saveCliente(@Argument ClienteInput cliente) {
        Cliente nuevoCliente = new Cliente(
            cliente.cedula(), 
            cliente.nombres(), 
            cliente.apellidos(), 
            cliente.direccion(), 
            cliente.telefono()
        );
        return clienteServicio.saveCliente(nuevoCliente);
    }

    @MutationMapping
    public Boolean deleteCliente(@Argument String cedula) {
        clienteServicio.deleteClienteById(cedula);
        return true;
    }
}