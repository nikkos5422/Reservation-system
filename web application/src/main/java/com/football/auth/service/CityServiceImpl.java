package com.football.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.auth.model.City;
import com.football.auth.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService{

	  @Autowired
	    private CityRepository cityRepository;
	  
	  @Override
	public City findBycityName(String cityName) {
        return cityRepository.findBycityName(cityName);
    }
	
}
