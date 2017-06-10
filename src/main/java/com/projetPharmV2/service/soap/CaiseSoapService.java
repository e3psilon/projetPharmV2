package com.projetPharmV2.service.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetPharmV2.entities.Caisse;
import com.projetPharmV2.metier.CaisseMetier;

@WebService
@Component
public class CaiseSoapService {
	@Autowired
	private CaisseMetier caisseMetier;

	@WebMethod
	public List<Caisse> listeCaisse() {
		return caisseMetier.listeCaisse();
	}

	@WebMethod
	public Caisse findOneCaisse(@WebParam(name = "idCaisse") Long idCaisse) {
		return caisseMetier.findOneCaisse(idCaisse);
	}
}
