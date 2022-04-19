package com.formacionbdi.microservicios.app.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.formacionbdi.microservicios.app.commons.service.CommonsService;


public class CommonsController<E, S extends CommonsService<E>> {

	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> listar(){		
		return ResponseEntity.ok().body(service.findAll());		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		
		Optional<E> a = service.findById(id);
		
		if(a.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(a.get());
		
	}
	
	@PostMapping
	public ResponseEntity<?> crear (@RequestBody E entity){
		E entityDb = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
