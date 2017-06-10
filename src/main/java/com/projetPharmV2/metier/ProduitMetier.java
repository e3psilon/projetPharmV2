package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Produit;

public interface ProduitMetier {

	public Produit saveProduit(Produit produit,Long idCategorie);

	public List<Produit> listeProduit();

	public void deleteProduit(Long idProduit);

	public Produit updateProduit(Produit produit);

	public Produit findOneProduit(Long barCodeProduit);

	public List<Produit> listeProduitsParMotCle(String mc);

	public List<Produit> listeProduitParCategorie(Long idCategorie);

	public List<Produit> produitsSelectionnes();
}
