package com.example.LaGranjaSA.controlador;

import com.example.LaGranjaSA.modelo.*;
import com.example.LaGranjaSA.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
