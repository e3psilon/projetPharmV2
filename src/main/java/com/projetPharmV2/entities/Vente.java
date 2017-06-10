package com.projetPharmV2.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vente")
//@Cacheable(value = true)
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Vente implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVente;
	private Date dateVente;
	@OneToMany(mappedBy = "vente")
	private Collection<LigneVente> ligneVentes;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nir", nullable = false, referencedColumnName = "nir")
	private Client client;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser", nullable = false, referencedColumnName = "idUser")
	private User user;
	@OneToMany(mappedBy = "caisse")
	private Collection<Transaction> transactions;


	public Long getIdVente() {
		return idVente;
	}

	public void setIdVente(Long idVente) {
		this.idVente = idVente;
	}

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}

	public Collection<LigneVente> getLigneVentes() {
		return ligneVentes;
	}

	public void setLigneVentes(Collection<LigneVente> ligneVentes) {
		this.ligneVentes = ligneVentes;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vente(Long idVente, Date dateVente) {
		super();
		this.idVente = idVente;
		this.dateVente = dateVente;
	}

}
