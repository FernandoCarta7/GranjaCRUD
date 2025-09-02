package com.example.LaGranjaSA.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cliente")
public class Cliente {
    @Id
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;

}
