package com.formacionbdi.microserviciosexamenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.microserviciosexamenes.models.entitys.Examen;

public interface ExamenRepository extends CrudRepository<Examen, Long> {

}
