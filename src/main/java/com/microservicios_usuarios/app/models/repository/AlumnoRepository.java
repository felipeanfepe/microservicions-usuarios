package com.microservicios_usuarios.app.models.repository;

import com.commons.models.entity.Alumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

    @Query("SELECT a FROM Alumno a WHERE a.nombre LIKE %?1% OR a.apellido LIKE %?1%")
    public List<Alumno> findByNombreOrApellido(String term);
}
