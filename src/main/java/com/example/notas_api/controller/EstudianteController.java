package com.example.notas_api.controller;

import com.example.notas_api.dto.*;
import com.example.notas_api.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v1/notas")
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<EntityModel<EstudianteDTO>> registrarNotas(@RequestBody NotasInputDTO input) {
        EstudianteDTO dto = estudianteService.guardarEstudianteConNotas(input);
        EntityModel<EstudianteDTO> model = EntityModel.of(dto);
        model.add(linkTo(methodOn(EstudianteController.class).obtenerNotas(input.getCedula())).withSelfRel());
        return ResponseEntity.ok(model);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<EntityModel<EstudianteDTO>> obtenerNotas(@PathVariable String cedula) {
        EstudianteDTO dto = estudianteService.obtenerPromedioYNotas(cedula);
        EntityModel<EstudianteDTO> model = EntityModel.of(dto);
        model.add(linkTo(methodOn(EstudianteController.class).obtenerNotas(cedula)).withSelfRel());
        return ResponseEntity.ok(model);
    }
}
