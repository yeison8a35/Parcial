package com.example.notas_api.dto;

import lombok.Data;
import java.util.List;

@Data
public class EstudianteDTO {
    private String cedula;
    private String nombre;
    private String apellido;
    private List<MateriaNotaDTO> materias;
    private Double promedio;
}
