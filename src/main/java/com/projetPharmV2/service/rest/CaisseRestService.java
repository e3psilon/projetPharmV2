package com.projetPharmV2.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetPharmV2.entities.Caisse;
import com.projetPharmV2.metier.CaisseMetier;

//@RestController
public class CaisseRestService {
	@Autowired
	private CaisseMetier caisseMetier;


	//@RequestMapping(value="/caisses",method=RequestMethod.GET)
	public List<Caisse> listeCaisse() {
		return caisseMetier.listeCaisse();
	}

	public Caisse findOneCaisse(Long idCaisse) {
		return caisseMetier.findOneCaisse(idCaisse);
	}
}
