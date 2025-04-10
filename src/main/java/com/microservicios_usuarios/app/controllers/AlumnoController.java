package com.microservicios_usuarios.app.controllers;

import com.commons.controllers.CommonController;
import com.microservicios_usuarios.app.models.entity.Alumno;
import com.microservicios_usuarios.app.services.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, Alumno alumno) {
        Optional<Alumno> o = service.findById(id);

        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Alumno alumnoDb = o.get();

        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }
}
