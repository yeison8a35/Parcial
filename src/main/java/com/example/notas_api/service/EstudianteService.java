package com.example.notas_api.service;

import com.example.notas_api.dto.NotasInputDTO;
import com.example.notas_api.model.Estudiante;
import com.example.notas_api.model.NotaMateria;
import com.example.notas_api.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public void guardarNotas(NotasInputDTO input) {
        Estudiante estudiante = new Estudiante();
        estudiante.setCedula(input.getCedula());
        estudiante.setNombre(input.getNombre());
        estudiante.setCorreo(input.getCorreo());

        input.getNotas().forEach(n -> {
            NotaMateria nota = new NotaMateria();
            nota.setMateria(n.getMateria());
            nota.setNota(n.getNota());
            nota.setEstudiante(estudiante);
            estudiante.getNotas().add(nota);
        });

        estudianteRepository.save(estudiante);
    }

    public Estudiante findByCedula(String cedula) {
        return estudianteRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }
}