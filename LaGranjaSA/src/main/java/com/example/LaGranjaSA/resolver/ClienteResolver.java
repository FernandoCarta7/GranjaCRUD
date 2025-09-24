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
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setCedula(cliente.cedula());
        nuevoCliente.setNombres(cliente.nombres());
        nuevoCliente.setApellidos(cliente.apellidos());
        nuevoCliente.setDireccion(cliente.direccion());
        nuevoCliente.setTelefono(cliente.telefono());
        
        return clienteServicio.saveCliente(nuevoCliente);
    }

    @MutationMapping
    public Cliente updateCliente(@Argument String cedula, @Argument ClienteInput cliente) {
        Cliente clienteExistente = clienteServicio.findClienteById(cedula);
        if (clienteExistente == null) {
            throw new RuntimeException("Cliente no encontrado con la cédula: " + cedula);
        }

        // Actualizar los campos del cliente existente
        if (cliente.nombres() != null) {
            clienteExistente.setNombres(cliente.nombres());
        }
        if (cliente.apellidos() != null) {
            clienteExistente.setApellidos(cliente.apellidos());
        }
        if (cliente.direccion() != null) {
            clienteExistente.setDireccion(cliente.direccion());
        }
        if (cliente.telefono() != null) {
            clienteExistente.setTelefono(cliente.telefono());
        }
        
        return clienteServicio.saveCliente(clienteExistente);
    }

    @MutationMapping
    public Boolean deleteCliente(@Argument String cedula) {
        clienteServicio.deleteClienteById(cedula);
        return true;
    }
}