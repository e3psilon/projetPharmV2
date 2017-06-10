package com.projetPharmV2.service.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.projetPharmV2.entities.Client;
import com.projetPharmV2.metier.ClientMetier;

//@RestController
public class ClientRestService {
	@Autowired
	private ClientMetier clientMetier;
	private static final Logger LOGGER =LoggerFactory.getLogger(ClientRestService.class);
	//@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public Client saveClient( Client client) {
		return clientMetier.saveClient(client);
	}



	//@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> listeClient() {
		return clientMetier.listeClient();
	}

	public void deleteClient(Client nir) {
		clientMetier.deleteClient(nir);
	}

	public void updateClient(Client nir) {
		clientMetier.updateClient(nir);
	}

	//@RequestMapping(value = "/clients/{path}", method = RequestMethod.GET)
	public Client findOneClient( Long nir) {
		return clientMetier.findOneClient(nir);
	}

}
