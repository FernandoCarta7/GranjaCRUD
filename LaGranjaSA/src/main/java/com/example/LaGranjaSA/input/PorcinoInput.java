package com.example.LaGranjaSA.input;

import com.example.LaGranjaSA.input.ClienteInput; // Corrected import
import com.example.LaGranjaSA.input.RazaInput;   // Corrected import

public record PorcinoInput(
    String id_porcino,
    String fecha_nacimiento,
    float peso,
    ClienteInput cliente, // Corrected type
    RazaInput raza,       // Corrected type
    int edad
) {}