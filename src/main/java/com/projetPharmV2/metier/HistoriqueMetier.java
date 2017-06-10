package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Historique;

public interface HistoriqueMetier {
	public Historique saveHistorique(Historique historique);

	public List<Historique> listeHistorique();

	public Historique findOneHistorique(Long idHistorique);
}
