package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Commande;

public interface CommandeMetier {
	public Commande saveCommande(Commande commande);

	public List<Commande> listeCommande();

	public void deleteCommande(Long idCommande);

	public void updateCommande(Commande commande);

	public Commande findOneCommande(Long idCommande);

}
