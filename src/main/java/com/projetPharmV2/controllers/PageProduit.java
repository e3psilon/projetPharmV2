package com.projetPharmV2.controllers;


import java.io.Serializable;
import java.util.List;

import com.projetPharmV2.entities.Produit;


public class PageProduit implements Serializable{
	private List<Produit> produits;
	private int page;
	private int nombreProduit;
	private int totalProduit;
	private int totolPages;
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreProduit() {
		return nombreProduit;
	}
	public void setNombreProduit(int nombreProduit) {
		this.nombreProduit = nombreProduit;
	}
	public int getTotalProduit() {
		return totalProduit;
	}
	public void setTotalProduit(int totalProduit) {
		this.totalProduit = totalProduit;
	}
	public int getTotolPages() {
		return totolPages;
	}
	public void setTotolPages(int totolPages) {
		this.totolPages = totolPages;
	}


}
