package com.projetPharmV2.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Caisse;
import com.projetPharmV2.entities.Transaction;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.entities.Vente;
import com.projetPharmV2.entities.dao.TransactionRepository;
import com.projetPharmV2.metier.TransactionMetier;
import com.projetPharmV2.metier.UserMetier;

@Service
public class TransactionMetierImpl implements TransactionMetier {

	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private UserMetier userMetier;

	@Override
	public Transaction saveTransaction(Transaction transaction, Long idUser, Caisse caisse, Vente venteStor) {
		User user = userMetier.findOneUser(idUser);
		transaction.setUser(user);
		transaction.setCaisse(caisse);
		transaction.setVente(venteStor);
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> listeTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction findOneTransaction(Long idTransaction) {

		return transactionRepository.findOne(idTransaction);
	}

	@Override
	public Transaction transactionParIDUser(Long idUser) {
		return transactionRepository.transactionParIDUser(idUser);
	}

}
