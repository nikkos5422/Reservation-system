package com.football.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.auth.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

	City findBycityName(String cityName);

	public List<City> findAll();

}
