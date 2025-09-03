package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> getClientes();
    public Cliente saveCliente();
    public Cliente findClienteById(String id);
    public void deleteClienteById(String id);
}
