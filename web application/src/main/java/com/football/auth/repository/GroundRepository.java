package com.football.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.auth.model.City;
import com.football.auth.model.Ground;

import java.util.List;

public interface GroundRepository extends JpaRepository<Ground, Long> {

	Ground findById(Long id);

	public List<Ground> findAllBytheCity(City cityname);
}
