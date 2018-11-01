package com.football.auth.controllers;

import com.football.auth.model.Match;
import com.football.auth.model.User;
import com.football.auth.service.SecurityService;
import com.football.auth.service.UserService;
import com.football.auth.validator.UserValidator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//controller for  user registration,uthorization and displaying user's reservation
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String aboutUs() {

		return "aboutUs";
	}

	@RequestMapping(value = { "/MyReservations" }, method = RequestMethod.GET)
	public ModelAndView UserReservations() {
		ModelAndView mav = new ModelAndView("MyReservations");

		List<Match> matches = new ArrayList<Match>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = userService.findByUsername(name);
		matches = user.getMatches();

		mav.addObject("matches", matches);

		return mav;

	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String SendRegistrationForm(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String MakeRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,
			Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {

		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

}
