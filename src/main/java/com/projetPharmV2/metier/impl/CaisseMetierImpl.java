package com.projetPharmV2.metier.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Caisse;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.entities.dao.CaisseRepository;
import com.projetPharmV2.metier.CaisseMetier;
import com.projetPharmV2.metier.UserMetier;

@Service
public class CaisseMetierImpl implements CaisseMetier {
	@Autowired
	CaisseRepository caisseRepository;
	@Autowired
	private TransactionMetierImpl transactionMetier;
	@Autowired
	private UserMetier userMetier;

	@Override
	public Caisse saveCaisse(Caisse caisse, Long idUser) {
		BigDecimal result = new BigDecimal(0);
		if (idUser != null) {
			User user = userMetier.findOneUser(idUser);

			caisse.setUsers(user);

			result = totatCaisse(caisse.getIdCaisse());
			BigDecimal sum = result.add(caisse.getTotalCaisse());
			caisse.setTotalCaisse(sum);
		}
		return caisseRepository.save(caisse);
	}

	@Override
	public List<Caisse> listeCaisse() {
		return caisseRepository.findAll();
	}

	@Override
	public Caisse findOneCaisse(Long idCaisse) {
		// TODO Auto-generated method stub
		return caisseRepository.findOne(idCaisse);
	}

	@Override
	public BigDecimal totatCaisse(Long idCaisse) {

		return caisseRepository.totatCaisse(idCaisse);
	}

}
