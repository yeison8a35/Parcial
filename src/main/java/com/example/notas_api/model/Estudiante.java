package com.example.notas_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    @Id
    private String cedula;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<NotaMateria> materias;
}
