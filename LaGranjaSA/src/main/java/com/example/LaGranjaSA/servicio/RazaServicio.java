package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Raza;
import com.example.LaGranjaSA.repositorio.RazaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RazaServicio implements IRazaServicio {

    @Autowired
    private RazaRepositorio razaRepositorio;

    @Override
    public List<Raza> findAll() {
        return razaRepositorio.findAll();
    }

    @Override
    public Raza findById(Integer id) {
        return razaRepositorio.findById(id).orElse(null);
    }

    @Override
    public Raza updateRaza(Raza raza) {
        return razaRepositorio.save(raza);
    }

    @Override
    public void deleteRaza(Integer id) {
        razaRepositorio.deleteById(id);
    }
}
