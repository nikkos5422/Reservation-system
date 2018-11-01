package com.football.auth.model;

//utility class for ejecting parametrs from ajax request
public class RequestParametrs {

	String selectedCity;
	int selectedId;

	public String getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(String selectedCity) {
		this.selectedCity = selectedCity;
	}

	public int getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}
}