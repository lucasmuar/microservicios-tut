package com.motoservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motoservice.entity.Moto;
import com.motoservice.repository.MotoRepository;

@Service
public class MotoService {

	@Autowired
	private MotoRepository motoRepository;
	
	public List<Moto> getAll(){
		return motoRepository.findAll();
	}
	
	public Optional<Moto> getMotoById(int id) {
		return motoRepository.findById(id);
	}

	public Moto save(Moto moto) {
		return motoRepository.save(moto);
	}
	
	public List<Moto> byUserId(int userId){
		return motoRepository.findByUserId(userId);
	}

	
}
