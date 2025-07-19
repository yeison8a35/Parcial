package com.example.notas_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    private String materia; //
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "cedula_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

}
