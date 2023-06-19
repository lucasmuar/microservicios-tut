package com.cocheservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocheservice.entity.Coche;
import com.cocheservice.service.CocheService;

@RestController
@RequestMapping("/car")
public class CocheController {

	@Autowired
	private CocheService cocheService;
	
	
	@GetMapping
	public ResponseEntity<List<Coche>> listCars(){
		List<Coche> cars = cocheService.getAll();
		
		if(cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(cars);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Optional<Coche>> getCar(@PathVariable("id") int id){
	
		if(cocheService.getCocheById(id) == null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(cocheService.getCocheById(id));
	}

	@PostMapping
	public ResponseEntity<Coche> saveCar(@RequestBody Coche coche){
		return ResponseEntity.ok(cocheService.save(coche));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Coche>> listCarsByUserId(@PathVariable("userId") int userId){
		List<Coche> cars = cocheService.byUserId(userId);
		
		if(cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(cars);
		
	}
	
	
}
