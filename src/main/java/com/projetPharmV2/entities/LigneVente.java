package com.projetPharmV2.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ligneVente")
//@Cacheable(value = true)
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LigneVente implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLigneVente;
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit;
	private int quantite;

	private BigDecimal prix;
	@ManyToOne
	@JoinColumn(name="idVente")
	private Vente vente;
	public Long getIdLigneVente() {
		return idLigneVente;
	}
	public void setIdLigneVente(Long idLigneVente) {
		this.idLigneVente = idLigneVente;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	public LigneVente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneVente(Long idLigneVente, int quantite, BigDecimal prix) {
		super();
		this.idLigneVente = idLigneVente;
		this.quantite = quantite;
		this.prix = prix;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
