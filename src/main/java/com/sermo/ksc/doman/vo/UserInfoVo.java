package com.sermo.ksc.doman.vo;

import java.io.Serializable;

/**
 * @author sermo
 * @version 2016年7月19日 
 */
public class UserInfoVo implements Serializable{
	
	private static final long serialVersionUID = -6283947186123309890L;

	private String name;
	
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
