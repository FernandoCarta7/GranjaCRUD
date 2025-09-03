package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Cliente;
import com.example.LaGranjaSA.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente findClienteById(String id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    @Override
    public void deleteClienteById(String id) {
        Cliente cliente = clienteRepositorio.findById(id).orElse(null);
        if (cliente != null) clienteRepositorio.deleteById(id);
    }


}
