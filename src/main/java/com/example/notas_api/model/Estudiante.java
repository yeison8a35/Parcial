package com.example.notas_api.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

import java.util.*;

@Entity
@Data
public class Estudiante {
    @Id
    private String cedula;

    private String nombre;
    private String correo;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotaMateria> notas = new ArrayList<>();

}
