package com.projetPharmV2.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Commande;
import com.projetPharmV2.entities.LigneCommande;
import com.projetPharmV2.entities.dao.LigneCommandeRepository;
import com.projetPharmV2.metier.LigneCommandeMetier;

@Service
public class LigneCommandeMetierImpl implements LigneCommandeMetier{
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	@Override
	public LigneCommande saveLigneCommande(LigneCommande ligneCommande) {
		return ligneCommandeRepository.save(ligneCommande);
	}

	@Override
	public List<LigneCommande> listeLigneCommande() {
		// TODO Auto-generated method stub
		return ligneCommandeRepository.findAll();
	}

	@Override
	public void deleteLigneCommande(Long idLigneCommande) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLigneCommande(LigneCommande commande) {
		// TODO Auto-generated method stub

	}

	@Override
	public Commande findOneLigneCommande(Long idLigneCommande) {
		// TODO Auto-generated method stub
		return null;
	}

}
