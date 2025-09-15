package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Alimentacion;
import com.example.LaGranjaSA.modelo.Raza;
import com.example.LaGranjaSA.repositorio.AlimentoRepositorio;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentacionServicio implements IAlimentacionServicio{

    @Autowired
    AlimentoRepositorio alimentoRepositorio;

    @Override
    public List<Alimentacion> getAlimentos() {
        return alimentoRepositorio.findAll();
    }

    @Override
    public Alimentacion findById(int id) {
        return alimentoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Alimentacion saveAlimentacion(Alimentacion alimentacion) {
        return alimentoRepositorio.save(alimentacion);
    }

    @Override
    public void deleteById(int id) {
        Alimentacion alimentacion = alimentoRepositorio.findById(id).orElse(null);
        if (alimentacion != null) alimentoRepositorio.deleteById(id);
    }

    public List<Alimentacion> findByRaza(Raza raza) {
        return alimentoRepositorio.findByRaza(raza);
    }
}
