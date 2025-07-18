package com.example.notas_api.controller.v1;

import com.example.notas_api.dto.EstudianteDTO;
import com.example.notas_api.dto.NotasInputDTO;
import com.example.notas_api.model.Estudiante;
import com.example.notas_api.service.EstudianteMapper;
import com.example.notas_api.service.EstudianteService;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v1")
public class EstudianteController {

    private final EstudianteService estudianteService;
    private final EstudianteMapper estudianteMapper;

    public EstudianteController(EstudianteService estudianteService, EstudianteMapper estudianteMapper) {
        this.estudianteService = estudianteService;
        this.estudianteMapper = estudianteMapper;
    }

    /**
     * GET /api/v1/notas/{cedula}
     */

    @GetMapping("/notas/{cedula}")
    public EntityModel<EstudianteDTO> getNotas(@PathVariable String cedula){
        Estudiante estudiante = estudianteService.findByCedula(cedula);
        EstudianteDTO dto = estudianteMapper.toDTO(estudiante);

        return EntityModel.of(dto,
                linkTo(methodOn(EstudianteController.class).getNotas(cedula)).withSelfRel(),
                linkTo(methodOn(EstudianteController.class).addNotas(null)).withRel("agregar-notas"));

    }

    /**
     * POST /api/v1/notas
     */
    @PostMapping("/notas")
    public ResponseEntity<?> addNotas(@RequestBody NotasInputDTO input) {
        estudianteService.guardarNotas(input);
        return ResponseEntity
                .created(linkTo(methodOn(EstudianteController.class).getNotas(input.getCedula())).toUri())
                .build();
    }
}
