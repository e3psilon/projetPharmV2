package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Client;
public interface ClientMetier {
	public Client saveClient(Client client);

	public List<Client> listeClient();

	public void deleteClient(Client nir);

	public void updateClient(Client nir);

	public Client findOneClient(Long nir);
}
