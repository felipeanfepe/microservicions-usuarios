package com.microservicios_usuarios.app.controllers;

import com.microservicios_usuarios.app.models.entity.Alumno;
import com.microservicios_usuarios.app.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<Alumno> o = alumnoService.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(o.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(Alumno alumno) {
        Alumno alumnoDb = alumnoService.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, Alumno alumno) {
        Optional<Alumno> o = alumnoService.findById(id);

        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Alumno alumnoDb = o.get();

        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoDb));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        Optional<Alumno> o = alumnoService.findById(id);

        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        alumnoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
