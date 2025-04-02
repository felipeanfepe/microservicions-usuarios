package com.microservicios_usuarios.app.models.repository;

import com.microservicios_usuarios.app.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;



public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
