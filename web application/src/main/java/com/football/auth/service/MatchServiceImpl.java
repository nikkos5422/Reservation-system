package com.football.auth.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.football.auth.model.Ground;
import com.football.auth.model.Match;
import com.football.auth.model.Team;
import com.football.auth.model.User;
import com.football.auth.repository.GroundRepository;
import com.football.auth.repository.MatchRepository;
import com.football.auth.repository.TeamRepository;
import com.football.auth.repository.UserRepository;

@Service
public class MatchServiceImpl implements MatchService{

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private GroundRepository groundRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamRepository teamRepository;
	
	@Override
	public void save(Match match) {
		
		Ground ground= groundRepository.findById((long) match.getGroundNumber());
		match.setTheGround(ground);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String username = auth.getName();
	     
	      User user = userRepository.findByUsername(username);
	   
	      Team teamA=new Team(1,"TeamA");
	      teamRepository.save(teamA);
	      teamA.addPlayer(user);
	      teamRepository.save(teamA);
	      
	      Team teamB =new Team(1,"TeamB");
	      teamRepository.save(teamB);
	      match.setTeam_A(teamA);
	      match.setTeam_B(teamB);

	    user.addMatch(match);
		setReservationCountGlobally(user.getMatches().size());

		
		matchRepository.save(match);
	}

	public void setReservationCountGlobally(int count) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		HttpSession session = request.getSession();
		session.setAttribute("reservationsCount", count);

	}

}
