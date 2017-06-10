package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Categorie;

public interface CategorieMetier {

	public Categorie saveCategorie(Categorie categorie);

	public List<Categorie> listeCategorie();

	public void deleteCategorie(Long idCategorie);

	public void updateCategorie(Categorie categorie);

	public Categorie findOneCategorie(Long idCategorie);

}
