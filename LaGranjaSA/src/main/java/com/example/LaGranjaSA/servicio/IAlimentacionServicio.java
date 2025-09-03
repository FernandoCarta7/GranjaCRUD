package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Alimentacion;

import java.util.List;

public interface IAlimentacionServicio {

    public List<Alimentacion> getAlimentos();
    public Alimentacion findById(int id);
    public Alimentacion saveAlimentacion(Alimentacion alimentacion);
    public void deleteById(int id);

}
