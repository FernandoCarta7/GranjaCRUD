// AlimentacionInput.java
package com.example.LaGranjaSA.input;

import com.example.LaGranjaSA.input.RazaInput; // Corrected import

public record AlimentacionInput(
    String id,
    RazaInput raza, // Corrected type
    String etapa,
    String descripcion,
    float dosis
) {}