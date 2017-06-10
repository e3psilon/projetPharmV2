package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Categorie;
import com.projetPharmV2.entities.Client;
import com.projetPharmV2.entities.LigneVente;
import com.projetPharmV2.entities.Panier;
import com.projetPharmV2.entities.Produit;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.entities.Vente;

/**
 * Interface des actions Vendeur
 *
 * @author e3psilon
 *
 */
public interface VendeurMetier {
	// fonction par categorie
	/*************************************************/
	public List<Categorie> listeCategorie();

	public Categorie getCategorie(Long idCategorie);
	public Categorie ajouterCategorie(Categorie categorie);

	public void supprimerCategorie(Long idCategorie);

	public void modifierCategorie(Categorie categorie);
	/*************************************************/
	//fonction par Produit
	/*************************************************/
	public Produit getProduit(Long idProduit);
	public List<Produit> listeProduit();

	public List<Produit> listeProduitParMotCle(String mc);

	public List<Produit> listeProduitParCategorie(Long idCategorie);

	public List<Produit> produitsSelectionnes();

	public Boolean disponibilieProduit(LigneVente ligneVente);
	public Produit ajouterProduitEnStock(Produit produit, Long idCategorie);

	public void supprimerProduit(Long BarCodeProduit);

	public void modifierProduit(Produit produit);

	/*************************************************/
	//Fonction Vente
	public Vente enregisterVente(Panier panier, Client client, User user);





	// public PageProduit getProduitPage(Long barCode, int page, int size);

}
