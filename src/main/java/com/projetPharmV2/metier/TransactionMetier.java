package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Caisse;
import com.projetPharmV2.entities.Transaction;
import com.projetPharmV2.entities.Vente;

public interface TransactionMetier {
	public Transaction saveTransaction(Transaction transaction, Long idUser, Caisse caisse, Vente venteStor);

	public List<Transaction> listeTransaction();

	public Transaction findOneTransaction(Long idTransaction);

	public Transaction transactionParIDUser(Long idUser);

}
