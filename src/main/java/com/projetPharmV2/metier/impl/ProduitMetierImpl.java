package com.projetPharmV2.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Categorie;
import com.projetPharmV2.entities.Produit;
import com.projetPharmV2.entities.dao.ProduitRepository;
import com.projetPharmV2.metier.CategorieMetier;
import com.projetPharmV2.metier.ProduitMetier;

@Service
public class ProduitMetierImpl implements ProduitMetier {
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	private CategorieMetier categorieMetier;

	@Override
	public List<Produit> listeProduit() {
		return produitRepository.findAll();
	}

	@Override
	public void deleteProduit(Long idProduit) {
		produitRepository.delete(idProduit);

	}

	@Override
	public Produit updateProduit(Produit produit) {
		Produit produitOld = findOneProduit(produit.getBarCodeProduit());
		produit.setQuantite(produit.getQuantite() + produitOld.getQuantite());
		return produitRepository.save(produit);

	}

	@Override
	public Produit findOneProduit(Long barCodeProduit) {
		return produitRepository.findOne(barCodeProduit);
	}

	@Override
	public List<Produit> listeProduitsParMotCle(String mc) {
		return produitRepository.listeProduitsParMotCle(mc);
	}

	@Override
	public List<Produit> listeProduitParCategorie(Long idCategorie) {
		return produitRepository.listeProduitParCategorie(idCategorie);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		return produitRepository.produitsSelectionnes();
	}

	@Override
	public Produit saveProduit(Produit produit, Long idCategorie) {
		Categorie categorie = categorieMetier.findOneCategorie(idCategorie);
		produit.setCategorie(categorie);
		return produitRepository.save(produit);
	}

}
