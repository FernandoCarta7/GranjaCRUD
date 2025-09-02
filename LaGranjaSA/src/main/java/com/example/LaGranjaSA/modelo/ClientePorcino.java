package com.example.LaGranjaSA.modelo;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cliente_porcino")
public class ClientePorcino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente_porcino;

    @ManyToOne
    @JoinColumn(name="cedula")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_porcino")
    private Porcino porcino;


}
