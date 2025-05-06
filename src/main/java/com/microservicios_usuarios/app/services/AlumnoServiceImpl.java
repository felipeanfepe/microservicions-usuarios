package com.microservicios_usuarios.app.services;
import com.commons.services.CommonServiceImpl;

import com.commons.models.entity.Alumno;
import com.microservicios_usuarios.app.models.repository.AlumnoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

    /**
     * @param term
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String term) {
        return repository.findByNombreOrApellido(term);
    }
}