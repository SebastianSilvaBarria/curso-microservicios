package com.formacionbdi.microservicioscursos.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.app.commons.controllers.CommonsController;
import com.formacionbdi.microservicioscursos.app.models.entity.Curso;
import com.formacionbdi.microservicioscursos.app.services.CursoServices;

@RestController
public class CursoController extends CommonsController<Curso, CursoServices> {

	@PutMapping("$/{id}")
	public ResponseEntity<?> editar (@RequestBody Curso curso, @PathVariable Long id){
		Optional<Curso> c = this.service.findById(id);
		if(c.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoDb = c.get();
		cursoDb.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
	}
	
	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id){
		Optional<Curso> c = this.service.findById(id);
		if(c.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoDb = c.get();
		alumnos.forEach(a -> {
			cursoDb.addListaAlumnos(a);
		});
				
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));		
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Curso> c = this.service.findById(id);
		if(c.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoDb = c.get();
		cursoDb.removeListaAlumnos(alumno);
				
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));		
	}
}
