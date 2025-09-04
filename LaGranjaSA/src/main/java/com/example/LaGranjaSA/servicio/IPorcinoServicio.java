package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Porcino;

import java.util.List;

public interface IPorcinoServicio {
    public Porcino getPorcinoById(int id);
    public List<Porcino> getPorcinos();
    public Porcino savePorcino(Porcino porcino);
    public void deletePorcinoById(int id);
}
