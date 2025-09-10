package com.example.LaGranjaSA.controlador;

import com.example.LaGranjaSA.modelo.*;
import com.example.LaGranjaSA.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inicio")
@CrossOrigin(value = "http://localhost:4200")
public class InicioController {

    @Autowired
    ClienteServicio  clienteServicio;

    @Autowired
    PorcinoServicio porcinoServicio;


    @GetMapping("/getClientes")
    public List<Cliente> getClientes(){
        return clienteServicio.getClientes();
    }

    @GetMapping("/getPorcinos")
    public List<Porcino> getPorcinos(){
        return porcinoServicio.getPorcinos();
    }

    @PostMapping("/guardarCliente")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteServicio.saveCliente(cliente);
    }
    @DeleteMapping("/deleteCliente/{cedula}")
    public ResponseEntity<Map<String, Boolean>> deleteCliente(@PathVariable String cedula){
        Cliente cliente = clienteServicio.findClienteById(cedula);
        if (cliente == null) return ResponseEntity.notFound().build();
        this.clienteServicio.deleteClienteById(cedula);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", true);
        return ResponseEntity.ok(response);
    }

}
