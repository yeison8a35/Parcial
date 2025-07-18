package com.example.notas_api.repository;

import com.example.notas_api.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
}