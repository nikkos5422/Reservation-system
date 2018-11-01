package com.football.auth.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String matchName;

	@Temporal(TemporalType.DATE)
	Date date;

	@Column
	private Integer entryFee;

	@Column
	private Integer capacity;

	@Column
	private String skillLevel;

	@ManyToOne
	@JoinColumn(name = "GROUND_ID")
	private Ground theGround;

	private int groundNumber;

	@Basic
	@DateTimeFormat(pattern = "HH:mm")
	private Date time;

	public Match() {
	}

	public Match(Date date, int entryFee, int capacity, Ground theGround, Team team_A, Team team_B, String name,
			String skill) {
		super();
		this.date = date;
		this.entryFee = entryFee;
		this.capacity = capacity;
		this.theGround = theGround;
		this.team_A = team_A;
		this.team_B = team_B;
		this.matchName = name;
		this.skillLevel = skill;
	}

	@ManyToOne
	@JoinColumn(name = "A_TEAM_ID")
	private Team team_A;

	@ManyToOne
	@JoinColumn(name = "B_TEAM_ID")
	private Team team_B;

	public Ground getTheGround() {
		return theGround;
	}

	public void setTheGround(Ground theGround) {
		this.theGround = theGround;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@JsonIgnore
	public Team getTeam_A() {
		return team_A;
	}

	public void setTeam_A(Team team_A) {
		this.team_A = team_A;
	}

	@JsonIgnore
	public Team getTeam_B() {
		return team_B;
	}

	public void setTeam_B(Team team_B) {
		this.team_B = team_B;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(Integer entryFee) {
		this.entryFee = entryFee;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public int getGroundNumber() {
		return groundNumber;
	}

	public void setGroundNumber(int groundNumber) {
		this.groundNumber = groundNumber;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
