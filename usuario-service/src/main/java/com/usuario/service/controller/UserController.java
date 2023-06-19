package com.usuario.service.controller;

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

import com.usuario.service.entidades.Usuario;
import com.usuario.service.models.Coche;
import com.usuario.service.models.Moto;
import com.usuario.service.service.UsuarioService;

@RestController
@RequestMapping(value ="/user")
public class UserController {
	@Autowired
	private UsuarioService userService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listUsers(){
		List<Usuario> usuarios = userService.getAll();
		
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(usuarios);
	}
	
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Optional<Usuario>> getUser(@PathVariable("id") int id){
	
		if(userService.getUserById(id) == null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario){
		return ResponseEntity.ok(userService.save(usuario));
	}
	
	@GetMapping(value ="/cars/{userId}")
	public ResponseEntity<List<Coche>> ListCars(@PathVariable("userId") int userId){
		Optional<Usuario> user = userService.getUserById(userId);
		
		if(user == null) {
			return ResponseEntity.noContent().build();
		}
		
		List<Coche> coches = userService.getCars(userId);
		
		return ResponseEntity.ok(coches);
	}
	
	
	@GetMapping(value ="/bikes/{userId}")
	public ResponseEntity<List<Moto>> ListBikes(@PathVariable("userId") int userId){
		Optional<Usuario> user = userService.getUserById(userId);
		
		if(user == null) {
			return ResponseEntity.noContent().build();
		}
		
		List<Moto> motos = userService.getBikes(userId);
		
		return ResponseEntity.ok(motos);
	}
	
	
}
