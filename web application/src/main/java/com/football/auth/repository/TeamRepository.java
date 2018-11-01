package com.football.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.auth.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	Team findById(Long id);
}
