package com.projetPharmV2.service.rest.objet;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginService implements Serializable{
	@NotEmpty
	private String login;
	@NotEmpty
	private String passWord;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


}
