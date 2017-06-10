package com.projetPharmV2.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Commande;
import com.projetPharmV2.entities.dao.CommandeRepository;
import com.projetPharmV2.metier.CommandeMetier;

@Service
public class CommandeMetierImpl implements CommandeMetier {
	@Autowired
	CommandeRepository commandeRepository;

	@Override
	public Commande saveCommande(Commande commande) {
		return commandeRepository.save(commande);
	}

	@Override
	public List<Commande> listeCommande() {
		return commandeRepository.findAll();
	}

	@Override
	public void deleteCommande(Long idCommande) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCommande(Commande commande) {
		// TODO Auto-generated method stub

	}

	@Override
	public Commande findOneCommande(Long idCommande) {
		return commandeRepository.findOne(idCommande);
	}

}
