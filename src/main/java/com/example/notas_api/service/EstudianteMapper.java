package com.example.notas_api.service;

import com.example.notas_api.dto.*;
import com.example.notas_api.model.*;
import java.util.List;
import java.util.stream.Collectors;

public class EstudianteMapper {

    public static EstudianteDTO toDTO(Estudiante estudiante, List<NotaMateria> materias) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setCedula(estudiante.getCedula());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());

        List<MateriaNotaDTO> materiaDTOs = materias.stream().map(m -> {
            MateriaNotaDTO mat = new MateriaNotaDTO();
            mat.setNombreMateria(m.getMateria());
            mat.setNota(m.getNota());
            return mat;
        }).collect(Collectors.toList());

        dto.setMaterias(materiaDTOs);
        double promedio = materiaDTOs.stream().mapToDouble(MateriaNotaDTO::getNota).average().orElse(0);
        dto.setPromedio(promedio);
        return dto;
    }
}
