package com.projetPharmV2.metier;

import com.projetPharmV2.entities.Categorie;
import com.projetPharmV2.entities.Produit;
import com.projetPharmV2.entities.User;

public interface OperationStockMetier {
	public void AjouterStockt(User user, Produit produit, Categorie categorie);

}
