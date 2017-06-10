package com.projetPharmV2.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Categorie;
import com.projetPharmV2.entities.dao.CategorieRepository;
import com.projetPharmV2.metier.CategorieMetier;


@Service
public class CategorieMetierImpl implements CategorieMetier {
	@Autowired
	CategorieRepository categrieRepository;

	@Override
	public Categorie saveCategorie(Categorie categorie) {
		return categrieRepository.save(categorie);
	}

	@Override
	public List<Categorie> listeCategorie() {
		return categrieRepository.findAll();
	}

	@Override
	public void deleteCategorie(Long idCategorie) {
		Categorie categorie = new Categorie();
		categorie=findOneCategorie(idCategorie);
		categrieRepository.delete(categorie);

	}

	@Override
	public void updateCategorie(Categorie categorie) {
		Categorie categorieOld = new Categorie();
		categorieOld=findOneCategorie(categorie.getIdCategorie());
		categorie=updateNewCategorie(categorie,categorieOld);
		categrieRepository.save(categorie);


	}

	private Categorie updateNewCategorie(Categorie categorie, Categorie categorieOld) {
		categorieOld.setDescription(categorie.getDescription());
		categorieOld.setNomCategorie(categorie.getNomCategorie());
		categorieOld.setNomPhoto(categorie.getNomPhoto());
		categorieOld.setPhoto(categorie.getPhoto());
		return categorieOld;
	}

	@Override
	public Categorie findOneCategorie(Long idCategorie) {
		return categrieRepository.findOne(idCategorie);
	}

}
