package com.cocheservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cocheservice.entity.Coche;
import com.cocheservice.repository.CocheRepository;

@Service
public class CocheService {

	@Autowired
	private CocheRepository cocheRepository;
	
	public List<Coche> getAll(){
		return cocheRepository.findAll();
	}
	
	public Optional<Coche> getCocheById(int id) {
		return cocheRepository.findById(id);
	}

	public Coche save(Coche coche) {
		return cocheRepository.save(coche);
	}
	
	public List<Coche> byUserId(int userId){
		return cocheRepository.findByUserId(userId);
	}

}
