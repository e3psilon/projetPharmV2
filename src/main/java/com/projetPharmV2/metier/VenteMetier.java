package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Vente;

public interface VenteMetier {
	public Vente saveVente(Vente vente, Long idUser, Long nir);

	public List<Vente> listeVente();

	public void deleteUser(Long idVente);

	public void updateVente(Vente vente);

	public Vente findOneVente(Long idVente);

}
