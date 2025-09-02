package com.example.LaGranjaSA.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "alimento_porciono")
public class AlimentacionPorcino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_alimentacion_porcino;

    @ManyToOne
    @JoinColumn(name="id_alimentoP")
    private Alimentacion alimentacion;

    @ManyToOne
    @JoinColumn(name = "id_porcinoA")
    private Porcino porcino;
}
