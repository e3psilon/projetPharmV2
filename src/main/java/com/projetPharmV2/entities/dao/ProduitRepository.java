package com.projetPharmV2.entities.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetPharmV2.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	@Query("select p from Produit p where p.designation like :mc or p.description like :mc")
	public List<Produit> listeProduitsParMotCle(@Param("mc") String mc);

	@Query("select p from Produit p where p.categorie.idCategorie=:mc ")
	public List<Produit> listeProduitParCategorie(@Param("mc") Long idCategorie);

	@Query("select p from Produit p where p.selected=true ")
	public List<Produit> produitsSelectionnes();


}
