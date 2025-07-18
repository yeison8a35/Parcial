package com.example.notas_api.repository;

import com.example.notas_api.model.NotaMateria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaMateriaRepository extends JpaRepository<NotaMateria, Long> {
    List<NotaMateria> findByEstudiante_Cedula(String cedula);
}
