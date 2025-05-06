package com.microservicios_usuarios.app.services;

import com.commons.models.entity.Alumno;
import com.commons.services.CommonService;

import java.util.List;


public interface AlumnoService extends CommonService<Alumno> {
    public List<Alumno> findByNombreOrApellido(String term);
}