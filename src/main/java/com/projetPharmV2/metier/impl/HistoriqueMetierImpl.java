package com.projetPharmV2.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Historique;
import com.projetPharmV2.entities.dao.HistoriqueRepository;
import com.projetPharmV2.metier.HistoriqueMetier;

@Service
public class HistoriqueMetierImpl implements HistoriqueMetier {
	@Autowired
	HistoriqueRepository historiqueRepository;

	@Override
	public Historique saveHistorique(Historique historique) {
		return historiqueRepository.save(historique);
	}

	@Override
	public List<Historique> listeHistorique() {
		// TODO Auto-generated method stub
		return historiqueRepository.findAll();
	}

	@Override
	public Historique findOneHistorique(Long idHistorique) {
		// TODO Auto-generated method stub
		return null;
	}

}
