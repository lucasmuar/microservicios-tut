package com.motoservice.controller;

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

import com.motoservice.entity.Moto;
import com.motoservice.service.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoController {
	@Autowired
	private MotoService motoService;
	
	
	@GetMapping
	public ResponseEntity<List<Moto>> listBikes(){
		List<Moto> bikes = motoService.getAll();
		
		if(bikes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(bikes);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Optional<Moto>> getBike(@PathVariable("id") int id){
	
		if(motoService.getMotoById(id) == null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(motoService.getMotoById(id));
	}

	@PostMapping
	public ResponseEntity<Moto> saveBike(@RequestBody Moto Moto){
		return ResponseEntity.ok(motoService.save(Moto));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Moto>> listBikesByUserId(@PathVariable("userId") int userId){
		List<Moto> bikes = motoService.byUserId(userId);
		
		if(bikes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(bikes);
		
	}
	
}
