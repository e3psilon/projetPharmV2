package com.projetPharmV2.metier.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Categorie;
import com.projetPharmV2.entities.Produit;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.metier.CategorieMetier;
import com.projetPharmV2.metier.OperationStockMetier;
import com.projetPharmV2.metier.ProduitMetier;

@Service
public class OperationStockMetierImpl implements OperationStockMetier {
	@Autowired
	private ProduitMetier produitMetier;
	private CategorieMetier categorieMetier;

	@Override
	public void AjouterStockt(User user, Produit produit, Categorie categorie) {
		if (produitMetier.findOneProduit(produit.getBarCodeProduit()) == null) {
			saveProduit(user, produit, categorie);
		} else {
			updateProduit(user, produit, categorie);
		}
	}

	private void updateProduit(User user, Produit produit, Categorie categorie) {
		produit.setNomMiseEnStock(user.getUserName());
		produit.setPrenomMiseEnStock(user.getPrenomUser());
		produit.setDateMiseEnStock(new Date());
		produitMetier.updateProduit(produit);
		categorieMetier.updateCategorie(categorie);

	}

	private void saveProduit(User user, Produit produit, Categorie categorie) {
		produit.setNomMiseEnStock(user.getUserName());
		produit.setPrenomMiseEnStock(user.getPrenomUser());
		produit.setDateMiseEnStock(new Date());
		produitMetier.saveProduit(produit,categorie.getIdCategorie());
		categorieMetier.saveCategorie(categorie);

	}

}
