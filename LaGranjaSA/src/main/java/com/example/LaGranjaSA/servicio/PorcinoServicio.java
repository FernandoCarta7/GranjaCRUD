package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Porcino;
import com.example.LaGranjaSA.repositorio.PorcinoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcinoServicio implements IPorcinoServicio{

    @Autowired
    PorcinoRepositorio porcinoRepositorio;

    @Override
    public Porcino getPorcinoById(int id) {
        return porcinoRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<Porcino> getPorcinos() {
        List<Porcino> lista = porcinoRepositorio.findAll();
        lista.sort((a,b) -> a.getRaza().getDescripcion().compareTo(b.getRaza().getDescripcion()));
        return lista;
    }

    @Override
    public Porcino savePorcino(Porcino porcino) {
        int edad = porcino.calcularEdad();
        porcino.setEdad(edad);
        return porcinoRepositorio.save(porcino);
    }


    @Override
    public void deletePorcinoById(int id) {
        Porcino porcino = getPorcinoById(id);
        if (porcino != null) porcinoRepositorio.deleteById(id);

    }
}
