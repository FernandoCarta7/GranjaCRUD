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
@Table(name = "raza")
public class Raza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String raza;
}
