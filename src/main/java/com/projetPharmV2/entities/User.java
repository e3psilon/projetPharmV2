package com.projetPharmV2.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.projetPharmV2.service.rest.objet.Profile;

@Entity
@Table(name = "user")
// @Cacheable(value = true)
// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	@NotEmpty
	@Size(min = 4, max = 200)
	private String userName;
	private String nomUser;
	private String prenomUser;
	@NotEmpty
	@Size(min = 4, max = 200)
	private String password;
	private boolean actived;

	private String telephone;

	private Profile profile;
	@OneToMany
	@JoinColumn(name = "idUser")
	private Collection<Role> roles;
	@OneToMany(mappedBy = "user")
	private Collection<Vente> ventes;
	@OneToMany(mappedBy = "user")
	private Collection<Transaction> transactions;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCaisse", nullable = true, referencedColumnName = "idCaisse")
	// @OneToMany(mappedBy = "user")
	private Caisse caisse;

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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<Vente> getVentes() {
		return ventes;
	}

	public void setVentes(Collection<Vente> ventes) {
		this.ventes = ventes;
	}

	public Collection<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long idUser, String userName, String nomUser, String prenomUser, String password, boolean actived) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.password = password;
		this.actived = actived;

	}

	public User(String userName, String nomUser, String prenomUser, String password, boolean actived,
			String telephone) {
		super();
		this.userName = userName;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.password = password;
		this.actived = actived;
		this.telephone = telephone;
	}



}
