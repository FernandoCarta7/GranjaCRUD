package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Porcino;
import com.example.LaGranjaSA.repositorio.PorcinoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PorcinoServicio implements IPorcinoServicio{

    @Autowired
    PorcinoRepositorio porcinoRepositorio;

    @Override
    public Porcino findPorcinoById(int id) {
        return porcinoRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<Porcino> findPorcinos() {
        return porcinoRepositorio.findAll();
    }

    @Override
    public Porcino savePorcino(Porcino porcino) {
        return porcinoRepositorio.save(porcino);
    }


    @Override
    public void deletePorcinoById(int id) {
        Porcino porcino = findPorcinoById(id);
        if (porcino != null) porcinoRepositorio.deleteById(id);

    }
}
