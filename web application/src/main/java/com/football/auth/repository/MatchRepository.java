package com.football.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.auth.model.Ground;
import com.football.auth.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

	public List<Match> findAllBytheGround(Ground groundname);

	Match findById(long id);
}
