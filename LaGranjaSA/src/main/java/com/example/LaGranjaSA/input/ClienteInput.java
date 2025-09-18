package com.example.LaGranjaSA.input;

public record ClienteInput(
    String cedula,
    String nombres,
    String apellidos,
    String direccion,
    String telefono
) {}