package com.formacionbdi.microservicios.app.usuarios.services;


import org.springframework.stereotype.Service;

import com.formacionbdi.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.app.commons.service.CommonsServiceImpl;
import com.formacionbdi.microservicios.app.usuarios.models.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl extends CommonsServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

}
