package com.projetPharmV2.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="histoique")
//@Cacheable(value = true)
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Historique implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iDTransaction;
	@NotEmpty
	private Date dateTransaction;
	@NotEmpty
	private int idUser;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String prenomUser;
	@NotEmpty
	private int nir;
	@NotEmpty
	private String nomClient;
	@NotEmpty
	private String prenomClient;

	@OneToMany(mappedBy = "historique")
	private Collection<Produit> produits;
	public Long getiDTransaction() {
		return iDTransaction;
	}
	public void setiDTransaction(Long iDTransaction) {
		this.iDTransaction = iDTransaction;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPrenomUser() {
		return prenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}
	public int getNir() {
		return nir;
	}
	public void setNir(int nir) {
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
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public Historique(Long iDTransaction, Date dateTransaction, int idUser, String userName, String prenomUser, int nir,
			String nomClient, String prenomClient, List<Produit> produits) {
		super();
		this.iDTransaction = iDTransaction;
		this.dateTransaction = dateTransaction;
		this.idUser = idUser;
		this.userName = userName;
		this.prenomUser = prenomUser;
		this.nir = nir;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.produits = produits;
	}
	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}



}
