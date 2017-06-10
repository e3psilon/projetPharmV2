package com.projetPharmV2.metier;

import java.math.BigDecimal;
import java.util.List;

import com.projetPharmV2.entities.Caisse;

public interface CaisseMetier {
	public Caisse saveCaisse(Caisse caisse, Long idUser);

	public List<Caisse> listeCaisse();

	public Caisse findOneCaisse(Long idCaisse);

	public BigDecimal totatCaisse(Long idLong);

}
