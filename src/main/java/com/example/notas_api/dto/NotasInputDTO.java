package com.example.notas_api.dto;

import lombok.Data;
import java.util.List;

@Data
public class NotasInputDTO {
    private String cedula;
    private String nombre;
    private String apellido;
    private List<MateriaNotaDTO> notas;
}