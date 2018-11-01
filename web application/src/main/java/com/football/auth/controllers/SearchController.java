package com.football.auth.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.football.auth.model.AjaxResponseBody;
import com.football.auth.model.City;
import com.football.auth.model.Ground;
import com.football.auth.model.Match;
import com.football.auth.model.RequestParametrs;
import com.football.auth.model.Team;
import com.football.auth.model.User;
import com.football.auth.repository.CityRepository;
import com.football.auth.repository.GroundRepository;
import com.football.auth.repository.MatchRepository;
import com.football.auth.repository.TeamRepository;
import com.football.auth.repository.UserRepository;
import com.football.auth.service.CityServiceImpl;

//controller for searching existing matches
@RestController
public class SearchController {

	@Autowired
	private GroundRepository gRepository;
	@Autowired
	private CityServiceImpl cityArray;

	@Autowired
	private MatchRepository matchRepo;
	@Autowired
	private GroundRepository Grepo;
	@Autowired
	private MatchRepository mRepo;

	@Autowired
	private UserRepository uRepo;

	@Autowired
	private TeamRepository teamrepo;

	@Autowired
	CityRepository cRepo;

	@RequestMapping(value = "/findNewMatch", method = RequestMethod.GET)
	public ModelAndView ShowAllCities() {

		ModelAndView model = new ModelAndView("findNewMatch");
		List<City> cities = cRepo.findAll();
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < cities.size(); i++)
			list.add(cities.get(i).getCityName());

		model.addObject("cities", list);

		return model;
	}

	@PostMapping("/api/getGrounds")
	public ResponseEntity<?> ReturnGroundsForAjax(@Valid @RequestBody RequestParametrs search) {
		AjaxResponseBody result = new AjaxResponseBody();

		City c = cityArray.findBycityName(search.getSelectedCity());
		List<Ground> grounds = gRepository.findAllBytheCity(c);

		result.setGrounds(grounds);
		result.setMsg(search.getSelectedCity());

		return ResponseEntity.ok(result);

	}

	@PostMapping("/api/getMatches")
	public ResponseEntity<?> ReturnMatchesForAjax(@Valid @RequestBody RequestParametrs search) {
		AjaxResponseBody result = new AjaxResponseBody();

		Ground tmp = Grepo.findById((long) search.getSelectedId());
		List<Match> matches = matchRepo.findAllBytheGround(tmp);

		result.setMatches(matches);
		result.setMsg("success");

		return ResponseEntity.ok(result);

	}

	@RequestMapping(value = "/api/showMatchInfo")
	public ModelAndView showMatchInfo(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView("matchDetail");

		Match match = mRepo.findById(id);
		mv.addObject("id", id);
		mv.addObject("entryFee", match.getEntryFee());
		mv.addObject("date", match.getDate());
		mv.addObject("mName", match.getMatchName());

		mv.addObject("team1", match.getTeam_A().getPlayers());
		mv.addObject("team2", match.getTeam_B().getPlayers());
		return mv;
	}

	@RequestMapping(value = "api/addPlayer")
	public ModelAndView addNewPlayer(@RequestParam Long id, @RequestParam String team) {

		ModelAndView mv = new ModelAndView("matchDetail");

		// get username of current user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = uRepo.findByUsername(name);

		Match match = matchRepo.findById(id);
		mv.addObject("entryFee", match.getEntryFee());
		mv.addObject("date", match.getDate());
		mv.addObject("mName", match.getMatchName());
		mv.addObject("team1", match.getTeam_A().getPlayers());
		mv.addObject("team2", match.getTeam_B().getPlayers());
		mv.addObject("id", id);

		if (alreadyParticipate(u, match)) {
			mv.addObject("error", "You have participated this match already!");
			return mv;
		}

		if (new String(team).equals("team_A")) {
			Team theTeam = match.getTeam_A();
			u.addMatch(match);

			theTeam.addPlayer(u);
			teamrepo.save(theTeam);
		}

		if (new String(team).equals("team_B")) {

			Team theTeam = match.getTeam_B();
			u.addMatch(match);
			theTeam.addPlayer(u);
			teamrepo.save(theTeam);
		}

		setReservationCountGlobally(u.getMatches().size());

		return mv;
	}

	// check if existing teams already contains current player
	public boolean alreadyParticipate(User u, Match m) {
		List<User> team1 = m.getTeam_A().getPlayers();
		List<User> team2 = m.getTeam_B().getPlayers();

		if ((team1.contains(u)) || (team2.contains(u))) {
			return true;
		}

		return false;
	}

	public void setReservationCountGlobally(int count) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		HttpSession session = request.getSession();
		session.setAttribute("reservationsCount", count);

	}

}
