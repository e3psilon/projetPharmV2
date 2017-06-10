package com.projetPharmV2.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Map<Long, LigneCommande> produits = new HashMap<Long, LigneCommande>();
	private Map<Long, LigneVente> ventes = new HashMap<Long, LigneVente>();

	/**
	 * les Operations de la commande
	 * Ajouter un produit pour une commande au fournisseur
	 * @param p
	 * @param quantite
	 */
	public void addArticleToCommande(Produit p, int quantite) {
		if (produits.get(p.getBarCodeProduit()) == null) {
			LigneCommande ligneCommande = new LigneCommande();
			ligneCommande.setProduit(p);
			ligneCommande.setQuantite(quantite);
			//ligneCommande.setPrix(p.getPrix());
		} else {
			LigneCommande ligneCommande = produits.get(p.getBarCodeProduit());
			ligneCommande.setQuantite(ligneCommande.getQuantite() + quantite);
		}
	}
	/**
	 * get nombre items de la commande au fournisseur
	 */
	public Collection<LigneCommande> getItems() {
		return produits.values();
	}
	/**
	 * Total de la commande au fournisseur
	 * @return
	 */
	public double getotal() {
		double total = 0;
		for (LigneCommande ligneCommande : produits.values()) {
			total += ligneCommande.getPrix() * ligneCommande.getQuantite();
		}
		return total;
	}

	public int getSizeCommande() {
		return produits.size();
	}
	/**
	 * supprimer un produit de la commande
	 * @param idProduit
	 */

	public void deleteProduitCommande(Long idProduit) {
		produits.remove(idProduit);
	}

	/**
	 * Les Operations de la ventes
	 *
	 * @param produit
	 * @param quantite
	 */
	public void addArticleVente(Produit produit, int quantite) {
		if (ventes.get(produit.getBarCodeProduit()) == null) {
			LigneVente ligneVente = new LigneVente();
			ligneVente.setProduit(produit);
			ligneVente.setQuantite(quantite);
			ligneVente.setPrix(produit.getPrix());
			ventes.put(produit.getBarCodeProduit(), ligneVente);
		} else {
			LigneVente ligneVente = ventes.get(produit.getBarCodeProduit());
			ligneVente.setQuantite(ligneVente.getQuantite() + quantite);

		}
	}
	/**
	 * get Article de la vente
	 * @return
	 */

	public Collection<LigneVente> getArticleVente(){
		return ventes.values();
	}
	/**
	 * Total de la vente
	 * @return
	 */
	public BigDecimal getTotalVente() {
		BigDecimal itemTotal=new BigDecimal(0);
		BigDecimal total=new BigDecimal(0);
		for(LigneVente ligneVente : ventes.values()) {

			itemTotal = ligneVente.getPrix().multiply(new BigDecimal(ligneVente.getQuantite()));
			total=total.add(itemTotal);
		}
		return total;
	}
	/**
	 * Nombre des articles
	 * @return
	 */
	public int getSizeVente() {
		return ventes.size();
	}
	/**
	 * Supprimer un produit
	 */
	public void deleteProduitVente(Long idProduit) {
		ventes.remove(idProduit);
	}
}
