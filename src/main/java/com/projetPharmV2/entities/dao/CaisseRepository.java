package com.projetPharmV2.entities.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetPharmV2.entities.Caisse;

public interface CaisseRepository extends JpaRepository<Caisse, Long> {

	@Query("select c.totalCaisse  from Caisse c where c.idCaisse=:idCaisse")
	public BigDecimal totatCaisse(@Param("idCaisse") Long idCaisse);
}
