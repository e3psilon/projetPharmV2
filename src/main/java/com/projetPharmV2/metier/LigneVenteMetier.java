package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.LigneVente;

public interface LigneVenteMetier {
	public LigneVente saveLigneVente(LigneVente ligneVente);

	public List<LigneVente> listeLigneVente();

	public void deleteLigneVente(Long idLigneVente);

	public void updateLigneVente(LigneVente ligneVente);

	public LigneVente findOneLigneVente(Long idLigneVente);

}
