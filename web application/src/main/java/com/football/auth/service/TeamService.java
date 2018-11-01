package com.football.auth.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.auth.model.Team;
import com.football.auth.repository.TeamRepository;
@Transactional
@Service
public class TeamService {

	@Autowired
	private TeamRepository teamrepo;
	
	public Team findbyId(long id) {
		
		return teamrepo.getOne(id);
	}
	
}
