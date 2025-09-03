package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Porcino;

import java.util.List;

public interface IPorcinoServicio {
    public Porcino findPorcinoById(int id);
    public List<Porcino> findPorcinos();
    public Porcino savePorcino(Porcino porcino);
    public void deletePorcinoById(int id);
}
