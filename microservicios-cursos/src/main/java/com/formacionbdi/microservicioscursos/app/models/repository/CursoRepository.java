package com.formacionbdi.microservicioscursos.app.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.microservicioscursos.app.models.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {

}
