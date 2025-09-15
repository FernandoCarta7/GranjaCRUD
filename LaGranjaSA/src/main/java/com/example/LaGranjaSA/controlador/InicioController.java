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

    @Autowired
    AlimentacionServicio alimentacionServicio;

    @Autowired
    RazaServicio razaServicio;

    /*
    --------------------------------------------------------------------
    --------------------------------------------------------------------
    ------------------------------CLIENTES------------------------------
    --------------------------------------------------------------------
    --------------------------------------------------------------------
     */

    @GetMapping("/getClientes")
    public List<Cliente> getClientes(){
        return clienteServicio.getClientes();
    }

    @GetMapping("/getClienteByCedula/{cedula}")
    public Cliente getClienteByCedula(@PathVariable String cedula){
        return clienteServicio.findClienteById(cedula);
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

    /*
     --------------------------------------------------------------------
     --------------------------------------------------------------------
     ------------------------------PORCINOS------------------------------
     --------------------------------------------------------------------
     --------------------------------------------------------------------
     */
    @GetMapping("/getPorcinos")
    public List<Porcino> getPorcinos(){
        return porcinoServicio.getPorcinos();
    }

    @DeleteMapping("/deletePorcinoById/{id_porcino}")
    public ResponseEntity<Map<String, Boolean>> deletePorcinoById(@PathVariable int id_porcino){
        Porcino porcino = porcinoServicio.getPorcinoById(id_porcino);
        if (porcino == null) return ResponseEntity.notFound().build();
        this.porcinoServicio.deletePorcinoById(id_porcino);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/agregarPorcino")
    public Porcino agregarPorcino (@RequestBody Porcino porcino){
        return porcinoServicio.savePorcino(porcino);

    }
    @GetMapping("/getPorcinoByIdPorcino/{id_porcino}")
    public Porcino getPorcinoById(@PathVariable int id_porcino){
        var porcino =  porcinoServicio.getPorcinoById(id_porcino);
        return porcinoServicio.getPorcinoById(id_porcino);
    }
    @PutMapping("/editarPorcino/{id_porcino}")
    public ResponseEntity<Porcino> editarPorcino(
            @PathVariable int id_porcino,
            @RequestBody Porcino porcinoRecibido){
        Porcino porcino = porcinoServicio.getPorcinoById(id_porcino);
        if (porcino == null) return ResponseEntity.notFound().build();
        else {
            porcino.getRaza().setDescripcion(porcinoRecibido.getRaza().getDescripcion());
            porcino.setPeso(porcinoRecibido.getPeso());
            porcino.setFecha_nacimiento(porcinoRecibido.getFecha_nacimiento());

            this.porcinoServicio.savePorcino(porcinoRecibido);
            return ResponseEntity.ok(porcino);
        }
    }

     /*
     --------------------------------------------------------------------
     --------------------------------------------------------------------
     ----------------------------ALIMENTACION----------------------------
     --------------------------------------------------------------------
     --------------------------------------------------------------------
     */

    @GetMapping("/getAlimentacion")
    public List<Alimentacion> getAlimentacion(){
        return alimentacionServicio.getAlimentos();
    }

    @DeleteMapping("/deleteAlimentacionById/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAlimentacionById(@PathVariable int id){
        Alimentacion alimentacion = alimentacionServicio.findById(id);
        if (alimentacion == null) return ResponseEntity.notFound().build();
        this.alimentacionServicio.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/agregarAlimentacion")
    public Alimentacion agregarAlimentacion (@RequestBody Alimentacion alimentacion){
        return alimentacionServicio.saveAlimentacion(alimentacion);

    }
    @GetMapping("/getAlimentacionById/{id}")
    public Alimentacion getAlimentacionById(@PathVariable int id){
        var alimentacion =  alimentacionServicio.findById(id);
        return alimentacion;
    }
    @PutMapping("/editarAlimentacion/{id}")
    public ResponseEntity<Alimentacion> editarAlimentacion(
            @PathVariable int id,
            @RequestBody Alimentacion alimentacionRecibido){
        Alimentacion alimentacion =alimentacionServicio.findById(id);
        if (alimentacion == null) return ResponseEntity.notFound().build();
        else {
            alimentacion.setDescripcion(alimentacionRecibido.getDescripcion());
            alimentacion.setDosis(alimentacionRecibido.getDosis());
            alimentacionServicio.saveAlimentacion(alimentacion);
            return ResponseEntity.ok(alimentacion);
        }
    }

    @GetMapping("/getAlimentacionByIdRaza")
    public List<Alimentacion> getAlimentacionByIdRaza(@RequestBody Raza raza){
        var lista = alimentacionServicio.findByRaza(raza);
        return lista;
    }

    /*
     --------------------------------------------------------------------
     --------------------------------------------------------------------
     -----------------------------RAZA-----------------------------------
     --------------------------------------------------------------------
     --------------------------------------------------------------------
     */
    @GetMapping("/getRaza/{descripcion}")
    public Raza getRazaByDescripcion(@PathVariable String descripcion){
        var raza = razaServicio.findByDescripcion(descripcion);
        return raza;
    }

}
