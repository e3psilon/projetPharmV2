package com.projetPharmV2.entities.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetPharmV2.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("select t from Transaction t where t.user.idUser =:idUser")
	public Transaction transactionParIDUser(@Param("idUser") Long idUser);

}
