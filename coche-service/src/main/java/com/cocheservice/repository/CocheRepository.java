package com.cocheservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cocheservice.entity.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer>{
	List<Coche> findByUserId(int userId);
}
