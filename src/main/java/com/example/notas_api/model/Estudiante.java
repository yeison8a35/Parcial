package com.example.notas_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private List<NotaMateria> materias;

}
