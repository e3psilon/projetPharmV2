package com.projetPharmV2.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "client")
//@Cacheable(value = true)
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Client implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	private Long nir;
	@NotEmpty
	@Size(min = 4, max = 200)
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	private String telephoneClient;
	@OneToMany(mappedBy = "client")
	private Collection<Commande> commandes;
	@OneToMany(mappedBy = "client")
	private Collection<Vente> ventes;




	public Long getNir() {
		return nir;
	}

	public void setNir(Long nir) {
		this.nir = nir;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public String getTelephoneClient() {
		return telephoneClient;
	}

	public void setTelephoneClient(String telephoneClient) {
		this.telephoneClient = telephoneClient;
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Long nir, String nomClient,String prenomClient, String adresseClient, String telephoneClient) {
		super();
		this.nir = nir;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresseClient = adresseClient;
		this.telephoneClient = telephoneClient;
	}



}
