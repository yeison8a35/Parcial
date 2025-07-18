package com.example.notas_api.service;

import com.example.notas_api.dto.EstudianteDTO;
import com.example.notas_api.dto.MateriaNotaDTO;
import com.example.notas_api.model.Estudiante;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class EstudianteMapper {

    public EstudianteDTO toDTO(Estudiante est){
        EstudianteDTO dto = new EstudianteDTO();
        dto.setCedula(est.getCedula());
        dto.setNombre(est.getNombre());
        dto.setNotas(
                est.getNotas().stream().map(n -> {
                    MateriaNotaDTO m = new MateriaNotaDTO();
                    m.setMateria(n.getMateria());
                    m.setNota(n.getNota());
                    return m;
                }).collect(Collectors.toList())
        );
        return dto;
    }
}
