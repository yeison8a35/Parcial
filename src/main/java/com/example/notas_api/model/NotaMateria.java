package com.example.notas_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreMateria;
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "cedula_estudiante")
    private Estudiante estudiante;
}
