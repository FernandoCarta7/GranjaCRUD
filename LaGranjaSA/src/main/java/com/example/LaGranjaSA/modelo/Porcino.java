package com.example.LaGranjaSA.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "porcino")
public class Porcino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_porcino;
    private String Raza;
    private LocalDate fecha_nacimiento;
    private float peso;
}
