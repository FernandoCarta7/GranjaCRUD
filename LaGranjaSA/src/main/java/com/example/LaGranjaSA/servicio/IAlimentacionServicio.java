package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Alimentacion;

import java.util.List;

public interface IAlimentacionServicio {

    public List<Alimentacion> getAlimentos();
    public Alimentacion findById(String id);
    public Alimentacion saveAlimentacion();
    public void deleteById(String id);

}
