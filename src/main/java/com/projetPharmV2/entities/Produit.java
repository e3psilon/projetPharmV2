package com.projetPharmV2.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "produit")
//@Cacheable(value = true)
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Produit implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long barCodeProduit;
	@NotEmpty
	@Size(min = 4, max = 200)
	private String designation;
	@Size(min = 4, max = 200)
	private String description;
	@NotEmpty
	@Size(min = 4, max = 200)
	private String nomFabriquant;
	@NotEmpty
	@Size(min = 4, max = 200)
	private String nomMiseEnStock;
	private String prenomMiseEnStock;
	private BigDecimal prix;
	private boolean selected;
	private String photo;
	private int quantiteComptoire;
	private int quantite;
	@NotNull
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date dateFabrication;
	@NotNull
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date datePeremption;
	@NotNull
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date dateMiseEnStock;
	@ManyToOne
	@JoinColumn(name = "idCategorie")
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name = "iDTransaction")
	private Historique historique;

	public Long getBarCodeProduit() {
		return barCodeProduit;
	}

	public void setBarCodeProduit(Long barCodeProduit) {
		this.barCodeProduit = barCodeProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getQuantiteComptoire() {
		return quantiteComptoire;
	}

	public void setQuantiteComptoire(int quantiteComptoire) {
		this.quantiteComptoire = quantiteComptoire;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Date getDateFabrication() {
		return dateFabrication;
	}

	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}

	public Date getDatePeremption() {
		return datePeremption;
	}

	public void setDatePeremption(Date datePeremption) {
		this.datePeremption = datePeremption;
	}

	public String getNomFabriquant() {
		return nomFabriquant;
	}

	public void setNomFabriquant(String nomFabriquant) {
		this.nomFabriquant = nomFabriquant;
	}

	public String getNomMiseEnStock() {
		return nomMiseEnStock;
	}

	public void setNomMiseEnStock(String nomMiseEnStock) {
		this.nomMiseEnStock = nomMiseEnStock;
	}

	public String getPrenomMiseEnStock() {
		return prenomMiseEnStock;
	}

	public void setPrenomMiseEnStock(String prenomMiseEnStock) {
		this.prenomMiseEnStock = prenomMiseEnStock;
	}

	public Date getDateMiseEnStock() {
		return dateMiseEnStock;
	}

	public void setDateMiseEnStock(Date dateMiseEnStock) {
		this.dateMiseEnStock = dateMiseEnStock;
	}

	public Historique getHistorique() {
		return historique;
	}

	public void setHistorique(Historique historique) {
		this.historique = historique;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(Long barCodeProduit, String designation, String description, String nomFabriquant,
			String nomMiseEnStock, String prenomMiseEnStock, BigDecimal prix, boolean selected, String photo,
			int quantiteComptoire, int quantite, Date dateFabrication, Date datePeremption, Date dateMiseEnStock) {
		super();
		this.barCodeProduit = barCodeProduit;
		this.designation = designation;
		this.description = description;
		this.nomFabriquant = nomFabriquant;
		this.nomMiseEnStock = nomMiseEnStock;
		this.prenomMiseEnStock = prenomMiseEnStock;
		this.prix = prix;
		this.selected = selected;
		this.photo = photo;
		this.quantiteComptoire = quantiteComptoire;
		this.quantite = quantite;
		this.dateFabrication = dateFabrication;
		this.datePeremption = datePeremption;
		this.dateMiseEnStock = dateMiseEnStock;
	}

	public Produit(Long barCodeProduit) {
		super();
		this.barCodeProduit = barCodeProduit;
	}

}
