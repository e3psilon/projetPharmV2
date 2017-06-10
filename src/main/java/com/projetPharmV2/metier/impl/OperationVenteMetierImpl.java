package com.projetPharmV2.metier.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Client;
import com.projetPharmV2.entities.LigneVente;
import com.projetPharmV2.entities.Panier;
import com.projetPharmV2.entities.Vente;
import com.projetPharmV2.metier.ClientMetier;
import com.projetPharmV2.metier.LigneVenteMetier;
import com.projetPharmV2.metier.OperationVenteMetier;
import com.projetPharmV2.metier.VenteMetier;
@Service
public class OperationVenteMetierImpl implements OperationVenteMetier {
	@Autowired
	private ClientMetier clientMetier;
	@Autowired
	private LigneVenteMetier ligneVenteMetier;
	@Autowired
	private VenteMetier venteMetier;
	@Override
	public Vente enregisterVente(Panier panier, Client client) {
		//charger l'ancien Client
		clientMetier.saveClient(client);
		Vente vente =new Vente();
		vente.setDateVente(new Date());
		vente.setLigneVentes(panier.getArticleVente());
		for(LigneVente ligneVente:panier.getArticleVente()) {
			ligneVenteMetier.saveLigneVente(ligneVente);
		}
		//venteMetier.saveVente(vente);
		//gestion stock
		return vente;
	}

}
