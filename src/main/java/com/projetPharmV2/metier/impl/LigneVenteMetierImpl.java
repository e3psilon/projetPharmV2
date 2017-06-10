package com.projetPharmV2.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.LigneVente;
import com.projetPharmV2.entities.dao.LigneVenteRepository;
import com.projetPharmV2.metier.LigneVenteMetier;
@Service
public class LigneVenteMetierImpl implements LigneVenteMetier{
	@Autowired
	LigneVenteRepository ligneVenteRepository;
	@Override
	public LigneVente saveLigneVente(LigneVente ligneVente) {
		return ligneVenteRepository.save(ligneVente);
	}

	@Override
	public List<LigneVente> listeLigneVente() {
		return ligneVenteRepository.findAll();
	}

	@Override
	public void deleteLigneVente(Long idLigneVente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLigneVente(LigneVente ligneVente) {
		// TODO Auto-generated method stub

	}

	@Override
	public LigneVente findOneLigneVente(Long idLigneVente) {
		// TODO Auto-generated method stub
		return null;
	}

}
