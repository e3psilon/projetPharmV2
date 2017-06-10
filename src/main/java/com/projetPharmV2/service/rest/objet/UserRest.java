package com.projetPharmV2.service.rest.objet;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long idUser;
	private String userName;
	private String nomUser;
	private String prenomUser;
	private String password;
	private boolean actived;
	@NotEmpty
	private List<String> authorities;

	@JsonIgnore
	private String publicSecret;

	@JsonIgnore
	private String privateSecret;

	private Profile profile;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public String getPublicSecret() {
		return publicSecret;
	}

	public void setPublicSecret(String publicSecret) {
		this.publicSecret = publicSecret;
	}

	public String getPrivateSecret() {
		return privateSecret;
	}

	public void setPrivateSecret(String privateSecret) {
		this.privateSecret = privateSecret;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public UserRest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRest(Long idUser, String userName, String nomUser, String prenomUser, String password, boolean actived) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.password = password;
		this.actived = actived;
	}

}
