package com.football.auth.model;

import java.util.List;

//utility class for creating ajax response
public class AjaxResponseBody {

	String msg;
	List<Ground> grounds;
	List<Match> matches;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Ground> getGrounds() {
		return grounds;
	}

	public void setGrounds(List<Ground> grounds) {
		this.grounds = grounds;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

}
