package com.football.auth.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.football.auth.model.City;
import com.football.auth.model.Match;
import com.football.auth.repository.CityRepository;
import com.football.auth.service.MatchService;

//controller for  creating new match
@Controller
public class NewMatchController {

	@Autowired
	private MatchService matchService;

	@Autowired
	private CityRepository cRepo;

	@RequestMapping(value = "/NewMatch", method = RequestMethod.GET)
	public String sendMatchForm(Model model) {
		model.addAttribute("matchForm", new Match());

		List<City> cities = cRepo.findAll();
		model.addAttribute("cities", cities);

		return "NewMatch";
	}

	@RequestMapping(value = "/NewMatch", method = RequestMethod.POST)
	public String CreateMatch(@ModelAttribute("matchForm") Match matchForm, Model model) {
		matchService.save(matchForm);

		return "redirect:/findNewMatch";

	}

	public void setReservationCountGlobally(int count) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		HttpSession session = request.getSession();
		session.setAttribute("reservationsCount", count);

	}

}
