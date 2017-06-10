package com.projetPharmV2.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Client;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.entities.Vente;
import com.projetPharmV2.entities.dao.VenteRepository;
import com.projetPharmV2.metier.ClientMetier;
import com.projetPharmV2.metier.UserMetier;
import com.projetPharmV2.metier.VenteMetier;

@Service
public class VenteMetierImpl implements VenteMetier {
	@Autowired
	private VenteRepository venteRepository;
	@Autowired
	private UserMetier userMetier;
	@Autowired
	private ClientMetier clientMetier;

	@Override
	public Vente saveVente(Vente vente, Long nir, Long idUser) {
		User user = userMetier.findOneUser(idUser);
		vente.setUser(user);
		Client client = clientMetier.findOneClient(nir);
		vente.setClient(client);

		return venteRepository.save(vente);
	}

	@Override
	public List<Vente> listeVente() {
		return venteRepository.findAll();
	}

	@Override
	public void deleteUser(Long idVente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateVente(Vente vente) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vente findOneVente(Long idVente) {
		// TODO Auto-generated method stub
		return null;
	}

}
