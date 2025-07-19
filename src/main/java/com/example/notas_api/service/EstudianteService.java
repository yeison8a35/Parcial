package com.example.notas_api.service;

import com.example.notas_api.dto.*;
import com.example.notas_api.model.*;
import com.example.notas_api.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository estudianteRepo;
    private final NotaMateriaRepository materiaRepo;

    public EstudianteDTO guardarEstudianteConNotas(NotasInputDTO input) {
        Estudiante estudiante = new Estudiante();
        estudiante.setCedula(input.getCedula());
        estudiante.setNombre(input.getNombre());
        estudiante.setApellido(input.getApellido());

        List<NotaMateria> materias = input.getNotas().stream().map(notaDTO -> {
            NotaMateria nota = new NotaMateria();
            nota.setMateria(notaDTO.getNombreMateria());
            nota.setNota(notaDTO.getNota());
            nota.setEstudiante(estudiante);
            return nota;
        }).collect(Collectors.toList());

        estudiante.setMaterias(materias);
        Estudiante saved = estudianteRepo.save(estudiante);

        return EstudianteMapper.toDTO(saved, materias);
    }

    public EstudianteDTO obtenerPromedioYNotas(String cedula) {
        Estudiante estudiante = estudianteRepo.findById(cedula).orElseThrow();
        List<NotaMateria> materias = materiaRepo.findByEstudiante_Cedula(cedula);
        return EstudianteMapper.toDTO(estudiante, materias);
    }
}
