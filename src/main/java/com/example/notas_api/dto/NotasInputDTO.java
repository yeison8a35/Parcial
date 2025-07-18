package com.example.notas_api.dto;

import com.example.notas_api.model.Estudiante;
import lombok.Data;

import java.util.List;

@Data
public class NotasInputDTO {
    private String cedula;
    private String nombre;
    private String correo;
    private List<MateriaNotaDTO> notas;
}
