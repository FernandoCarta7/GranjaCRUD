package com.example.LaGranjaSA.servicio;

import com.example.LaGranjaSA.modelo.Raza;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRazaServicio {
    public List<Raza> findAll();
    public Raza findById(Integer id);
    public Raza updateRaza(Raza raza);
    public void deleteRaza(Integer id);
}
