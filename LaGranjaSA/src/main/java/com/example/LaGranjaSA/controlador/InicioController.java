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

    @GetMapping("/getClienteByCedula/{cedula}")
    public Cliente getClienteByCedula(@PathVariable String cedula){
        return clienteServicio.findClienteById(cedula);
    }

    @GetMapping("/getPorcinos")
    public List<Porcino> getPorcinos(){
        return porcinoServicio.getPorcinos();
    }

    @PostMapping("/saveCliente")
    public Cliente saveCliente(@RequestBody Cliente cliente){
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
    @PutMapping("/editarPaciente/{cedula}")
    public ResponseEntity<Cliente> editarPaciente(
            @PathVariable String cedula,
            @RequestBody Cliente clienteRecibido){
        Cliente cliente = this.clienteServicio.findClienteById(cedula);
        if (cliente == null) return ResponseEntity.notFound().build();
        else {
            cliente.setApellidos(clienteRecibido.getApellidos());
            cliente.setNombres(clienteRecibido.getNombres());
            cliente.setDireccion(clienteRecibido.getDireccion());
            cliente.setTelefono(clienteRecibido.getTelefono());
            this.clienteServicio.saveCliente(cliente);
            return ResponseEntity.ok(cliente);
        }

    }

}
