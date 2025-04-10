package com.microservicios_usuarios.app.services;
import com.commons.services.CommonServiceImpl;

import com.microservicios_usuarios.app.models.entity.Alumno;
import com.microservicios_usuarios.app.models.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

}