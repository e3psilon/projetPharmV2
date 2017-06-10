package com.projetPharmV2.metier;

import com.projetPharmV2.entities.Client;
import com.projetPharmV2.entities.Panier;
import com.projetPharmV2.entities.Vente;

public interface OperationVenteMetier {
	public Vente enregisterVente(Panier panier, Client client);

}
