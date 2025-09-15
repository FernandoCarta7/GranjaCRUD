package com.example.LaGranjaSA.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

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
    private LocalDate fecha_nacimiento;
    private float peso;
    @ManyToOne
    @JoinColumn(name = "fk_id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fk_id_raza")
    private Raza raza;
    private int edad;
    public int calcularEdad() {
        if (fecha_nacimiento == null) {
            return 0;

        }
        return Period.between(fecha_nacimiento, LocalDate.now()).getDays();
    }

}
