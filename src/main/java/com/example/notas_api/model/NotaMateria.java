package com.example.notas_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
public class NotaMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String materia;
    private double nota;

    @ManyToOne
    @JoinColumn(name = "cedula_estudiante")
    private Estudiante estudiante;

}
