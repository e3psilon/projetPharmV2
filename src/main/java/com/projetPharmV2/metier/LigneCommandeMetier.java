package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Commande;
import com.projetPharmV2.entities.LigneCommande;

public interface LigneCommandeMetier {
	public LigneCommande saveLigneCommande(LigneCommande commande);

	public List<LigneCommande> listeLigneCommande();

	public void deleteLigneCommande(Long idLigneCommande);

	public void updateLigneCommande(LigneCommande commande);

	public Commande findOneLigneCommande(Long idLigneCommande);
}
