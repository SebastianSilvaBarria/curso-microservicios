package com.formacionbdi.microservicioscursos.app.services;


import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.commons.service.CommonsServiceImpl;
import com.formacionbdi.microservicioscursos.app.models.entity.Curso;
import com.formacionbdi.microservicioscursos.app.models.repository.CursoRepository;

@Service
public class CursoServiceImpl extends CommonsServiceImpl<Curso, CursoRepository> implements CursoServices {


}
