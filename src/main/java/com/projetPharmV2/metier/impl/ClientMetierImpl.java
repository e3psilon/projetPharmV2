package com.projetPharmV2.metier.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Client;
import com.projetPharmV2.entities.dao.ClientRepository;
import com.projetPharmV2.metier.ClientMetier;

@Service
public class ClientMetierImpl implements ClientMetier {
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public List<Client> listeClient() {
		return clientRepository.findAll();
	}

	@Override
	public Client findOneClient(Long nir) {

		return clientRepository.findOne(nir);
	}

	@Override
	public void deleteClient(Client client) {

		findOneClient(client.getNir());
		clientRepository.delete(client);

	}

	@Override
	public void updateClient(Client client) {
		Client clientFind = new Client();
		clientFind =findOneClient(client.getNir());
		clientRepository.save(client);

	}

}
