package com.football.auth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.football.auth.model.City;
import com.football.auth.model.Ground;
import com.football.auth.model.Match;
import com.football.auth.model.Team;
import com.football.auth.model.User;
import com.football.auth.repository.CityRepository;
import com.football.auth.repository.GroundRepository;
import com.football.auth.repository.MatchRepository;
import com.football.auth.repository.TeamRepository;
import com.football.auth.service.UserService;

//class for setting up minimal enough data
@Component
public class DataSetup {

	@Autowired
	private UserService userservice;

	@Autowired
	private TeamRepository teamRepo;

	@Autowired
	private MatchRepository matchRepo;
	@Autowired
	private GroundRepository Grepo;

	@Autowired
	private CityRepository cRepo;

	@PostConstruct
	@Transactional
	private void saveMe() throws ParseException {

		// user for testing, use this data for authorize in app
		User user = new User("kosarnik", "54221001");
		userservice.save(user);

		// date formate for matches date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

		// creating teams
		Team team_1 = new Team(1, "FIT");
		teamRepo.save(team_1);

		Team team_2 = new Team(0, "FEL");
		teamRepo.save(team_2);

		Team team_3 = new Team(0, "FSv");
		teamRepo.save(team_3);

		Team team_4 = new Team(5, "FS");
		teamRepo.save(team_4);

		Team team_5 = new Team(6, "FA");
		teamRepo.save(team_5);

		Team team_6 = new Team(3, "FJFI");
		teamRepo.save(team_6);

		// creating the cities

		City p = new City("Prague", "Czech Republic");
		City y = new City("Yalta", "Crimea");
		cRepo.save(y);
		cRepo.save(p);

		// creating the grounds
		Ground gp1 = new Ground("Sparta", "grass", p, "/../resources/sparta4.jpg");
		gp1.setAddress("M. Horákové 1066/98, 170 82 Praha 7");
		Ground gp2 = new Ground("Sokol Troja", "artificial", p, "/../resources/sokol3.jpg");
		gp2.setAddress("Na Kazance 637/1, 171 00 Praha-Troja");
		Ground gp3 = new Ground("Vitkov", "grit", p, "/../resources/vitkov2.jpg");
		gp3.setAddress("Pražačka, 130 00 Praha 3");
		Ground gp4 = new Ground("JuBK", "grit", y, "/../resources/jubk.jpg");
		gp4.setAddress("Brno,Bieblova 33");
		Grepo.save(gp1);
		Grepo.save(gp2);
		Grepo.save(gp3);
		Grepo.save(gp4);

		// CREATING MATCH "MM/dd/yy"
		Date matchdate = dateFormat.parse("04/08/2018");
		Date matchdate2 = dateFormat.parse("04/09/2018");

		Match m_1 = new Match(matchdate, 0, 22, gp1, team_1, team_2, "firstMatch", "BEGINNER");
		matchRepo.save(m_1);

		Match m_2 = new Match(matchdate, 0, 22, gp1, team_3, team_4, "secondMatch", "BEGINNER");
		matchRepo.save(m_2);

		Match m_3 = new Match(matchdate2, 0, 22, gp1, team_5, team_6, "thirdMatch", "ADVANCED");
		matchRepo.save(m_3);

		Match m_4 = new Match(matchdate2, 0, 22, gp1, team_1, team_6, "fourthMatch", "BEGINNER");
		matchRepo.save(m_4);

		Match m_6 = new Match(matchdate, 0, 22, gp4, team_1, team_4, "sixthMatch", "ADVANCED");
		matchRepo.save(m_6);

		createUser(m_1);

	}

	// creating new users and addind them in the teams
	public void createUser(Match m) {

		List<User> userSet_1 = new ArrayList<User>();
		List<User> userSet_2 = new ArrayList<User>();
		Team t1 = m.getTeam_A();
		Team t2 = m.getTeam_B();
		// First team
		User user1 = new User("Tanirbegen Tlegenov", "54221001");
		userservice.save(user1);
		User user2 = new User("Dominik Hanak", "54221001");
		userservice.save(user2);
		User user3 = new User("Maxim Petrov", "54221001");
		userservice.save(user3);
		User user4 = new User("Boris Laskov", "54221001");
		userservice.save(user4);
		User user5 = new User("Gleb Sidorov", "54221001");
		userservice.save(user5);
		User user100 = new User("Petr Prazak", "54221001");
		userservice.save(user100);

		userSet_1.add(user100);
		userSet_1.add(user1);
		userSet_1.add(user2);
		userSet_1.add(user3);
		userSet_1.add(user4);
		userSet_1.add(user5);
		t1.setPlayers(userSet_1);
		teamRepo.save(t1);

		// second team
		User user6 = new User("Peter Jason Quel", "54221001");
		userservice.save(user6);
		User user7 = new User("Jan Parma", "54221001");
		userservice.save(user7);
		User user8 = new User("Hans Huberman", "54221001");
		userservice.save(user8);
		User user9 = new User("Nikolai Kosariev", "54221001");
		userservice.save(user9);
		User user10 = new User("Martin Novotny", "54221001");
		userservice.save(user10);

		userSet_2.add(user6);
		userSet_2.add(user7);
		userSet_2.add(user8);
		userSet_2.add(user9);
		userSet_2.add(user10);
		t2.setPlayers(userSet_2);
		teamRepo.save(t2);

	}

}
