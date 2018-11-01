package com.football.auth.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String cityName;

	@Column
	private String country;

	@OneToMany(mappedBy = "theCity")
	private Set<Ground> grounds;

	public City(String cityName, String country) {
		super();
		this.cityName = cityName;
		this.country = country;
	}

	public City() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@JsonIgnore
	public Set<Ground> getGrounds() {
		return grounds;
	}

	public void setGrounds(Set<Ground> grounds) {
		this.grounds = grounds;
	}

}
