package com.projetPharmV2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="ligneCommande")
//@Cacheable(value = true)
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LigneCommande implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLigneCommande;
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit;
	private int quantite;
	@NotEmpty
	@Size(min=2,max=200)
	private double prix;
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdLigneCommande() {
		return idLigneCommande;
	}
	public void setIdLigneCommande(Long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public LigneCommande(double prix) {
		super();
		this.prix = prix;
	}


}
