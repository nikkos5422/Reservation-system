package com.football.auth.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ground {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Ground() {
	}

	public Ground(String groundName, String covering, City theCity, String image) {
		super();
		this.groundName = groundName;

		this.covering = covering;
		this.theCity = theCity;
		this.image = image;
	}

	@Column
	private String image;

	@Column
	private String groundName;

	@Column
	private String address;

	@Column
	private String covering;

	@ManyToOne
	@JoinColumn(name = "CITY_ID")
	private City theCity;

	@OneToMany(mappedBy = "theGround")
	private Set<Match> matches;

	@JsonIgnore
	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCovering() {
		return covering;
	}

	public void setCovering(String covering) {
		this.covering = covering;
	}

	@JsonIgnore
	public City getTheCity() {
		return theCity;
	}

	public void setTheCity(City theCity) {
		this.theCity = theCity;
	}

	@Override
	public String toString() {
		return "Ground{" + "name='" + this.getGroundName() + '\'' + ", covering='" + this.getCovering() + '\'' + '}';
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
