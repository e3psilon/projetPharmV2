package com.projetPharmV2.metier.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Caisse;
import com.projetPharmV2.entities.Categorie;
import com.projetPharmV2.entities.Client;
import com.projetPharmV2.entities.LigneVente;
import com.projetPharmV2.entities.Panier;
import com.projetPharmV2.entities.Produit;
import com.projetPharmV2.entities.Role;
import com.projetPharmV2.entities.Transaction;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.entities.Vente;
import com.projetPharmV2.metier.AdminProduitMetier;
import com.projetPharmV2.metier.CaisseMetier;
import com.projetPharmV2.metier.CategorieMetier;
import com.projetPharmV2.metier.ClientMetier;
import com.projetPharmV2.metier.LigneVenteMetier;
import com.projetPharmV2.metier.ProduitMetier;
import com.projetPharmV2.metier.UserMetier;
import com.projetPharmV2.metier.VenteMetier;

@Service
public class BoutiqueMetierImpl implements AdminProduitMetier {
	@Autowired
	private CategorieMetier categorieMetier;
	@Autowired
	private ProduitMetier produitMetier;
	@Autowired
	private VenteMetier venteMetier;
	@Autowired
	private UserMetier userMetier;
	@Autowired
	private ClientMetier clientMetier;
	@Autowired
	private LigneVenteMetier ligneVenteMetier;
	@Autowired
	private CaisseMetier caisseMetier;
	@Autowired
	private TransactionMetierImpl transactionMetier;

	@Override
	public List<Categorie> listeCategorie() {

		return categorieMetier.listeCategorie();
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		return categorieMetier.findOneCategorie(idCategorie);
	}

	@Override
	public List<Produit> listeProduit() {
		return produitMetier.listeProduit();
	}

	@Override
	public List<Produit> listeProduitParMotCle(String mc) {
		return produitMetier.listeProduitsParMotCle(mc);
	}

	@Override
	public List<Produit> listeProduitParCategorie(Long idCategorie) {
		return produitMetier.listeProduitParCategorie(idCategorie);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		return produitMetier.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idProduit) {
		return produitMetier.findOneProduit(idProduit);
	}

	@Override
	public Vente enregisterVente(Panier panier, Client client, User user) {
		Client clientOld = new Client();
		Vente vente = new Vente();
		vente.setDateVente(new Date());
		vente.setLigneVentes(panier.getArticleVente());
		clientOld = clientMetier.findOneClient(client.getNir());
		// si le client n'existe pas
		if (clientOld == null) {
			clientMetier.saveClient(client);
			// Sauvegarde de ligne de vente
			sauvegardeLigneVente(panier, vente, client.getNir(), user.getIdUser());

			return vente;
		} else {
			// Sauvegarde de ligne de vente
			sauvegardeLigneVente(panier, vente, client.getNir(), user.getIdUser());
			return vente;
		}
	}

	// Sauvegarde de ligne de vente
	private void sauvegardeLigneVente(Panier panier, Vente vente, Long nir, Long iDUser) {
		// Sauvegarde de la vente
		Vente venteStor = venteMetier.saveVente(vente, nir, iDUser);
		for (LigneVente ligneVente : panier.getArticleVente()) {
			//if (disponibilieProduit(ligneVente)) {
				// Update du produit
				updateProduitDeductionStock(ligneVente.getProduit(),ligneVente.getQuantite());
				// Sauvegarde de la ligne de Vente
				ligneVenteMetier.saveLigneVente(ligneVente);
			//}
		}
		// Sauvegarde de la vente en caisse
		Caisse caisse = caisseMetier.saveCaisse(construireCaisse(panier.getTotalVente()), iDUser);
		// Sauvegarde de la transaction
		transactionMetier.saveTransaction(construireTransaction(panier.getTotalVente()), iDUser, caisse, venteStor);

	}

	private void updateProduitDeductionStock(Produit produit, int quantiteProduit) {
		int quantiteAjour=0;
		Produit produitOld = produitMetier.findOneProduit(produit.getBarCodeProduit());
		if (produitOld == null||produitOld.getQuantite() < quantiteProduit) {
			System.out.println("produit indisponible");
		} else {
			quantiteAjour = produitOld.getQuantite() - quantiteProduit;
			produitOld.setQuantite(quantiteAjour);
			produit = produitMetier.saveProduit(produitOld,produitOld.getCategorie().getIdCategorie());
		}

	}

	// Construire la transaction
	private Transaction construireTransaction(BigDecimal totalTransaction) {
		Transaction transaction = new Transaction(totalTransaction, new Date(), null);
		return transaction;
	}

	// faire attention a la caisse
	private Caisse construireCaisse(BigDecimal prixTotal) {
		Caisse caisse = new Caisse(3L, prixTotal, new Date());
		return caisse;
	}

	@Override
	public Produit ajouterProduitEnStock(Produit produit, Long idCategorie) {
		int quantite = 0;
		Produit produitOld = produitMetier.findOneProduit(produit.getBarCodeProduit());
		if (produitOld == null) {
			return produitMetier.saveProduit(produit, idCategorie);
		} else {
			quantite = produit.getQuantite() + produitOld.getQuantite();
			produit.setQuantite(quantite);
			return produitMetier.saveProduit(produit, idCategorie);
		}

	}

	@Override
	public void supprimerProduit(Long barCodeProduit) {
		produitMetier.deleteProduit(barCodeProduit);
	}

	@Override
	public void modifierProduit(Produit produit) {
		produitMetier.updateProduit(produit);

	}

	@Override
	public Categorie ajouterCategorie(Categorie categorie) {
		return categorieMetier.saveCategorie(categorie);
	}

	@Override
	public void supprimerCategorie(Long idCategorie) {
		categorieMetier.deleteCategorie(idCategorie);
	}

	@Override
	public void modifierCategorie(Categorie categorie) {
		categorieMetier.updateCategorie(categorie);
	}

	@Override
	public void ajouterUser(User user) {
		userMetier.saveUser(user);
	}

	@Override
	public void attribuerRole(Role role, Long userID) {
		User user = new User();
		user = userMetier.findOneUser(userID);
		user.getRoles().add(role);
		userMetier.saveUser(user);

	}

	@Override
	public List<Caisse> listeCaisse() {
		return caisseMetier.listeCaisse();
	}

	@Override
	public Caisse getCaisse(Long idTransaciotn) {
		return caisseMetier.findOneCaisse(idTransaciotn);
	}

	@Override
	public List<Vente> listeVentes() {
		return venteMetier.listeVente();
	}

	@Override
	public Boolean disponibilieProduit(LigneVente ligneVente) {
		Produit produitOld = produitMetier.findOneProduit(ligneVente.getProduit().getBarCodeProduit());
		if (produitOld.getQuantite() < ligneVente.getQuantite()) {
			return true;
		}
		return false;
	}

}
