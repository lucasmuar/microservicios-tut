package com.usuario.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.models.Coche;
import com.usuario.service.models.Moto;
import com.usuario.service.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Coche> getCars(int userId){
		return restTemplate.getForObject("http://localhost:8080/car/user/" + userId, List.class);
	}
	
	public List<Moto> getBikes(int userId){
		return restTemplate.getForObject("http://localhost:8083/moto/user/" + userId, List.class);
	}
	
	public List<Usuario> getAll(){
		return userRepository.findAll();
	}
	
	public Optional<Usuario> getUserById(int id) {
		return userRepository.findById(id);
	}

	public Usuario save(Usuario usuario) {
		return userRepository.save(usuario);
	}
}