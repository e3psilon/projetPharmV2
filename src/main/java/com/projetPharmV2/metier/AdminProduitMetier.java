package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Caisse;
import com.projetPharmV2.entities.Role;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.entities.Vente;

/**
 * Interface des actions Admin
 *
 * @author e3psilon
 *
 */
public interface AdminProduitMetier extends VendeurMetier {
	//Ajouter un User
	public void ajouterUser(User user);
	//Ajouter un Role
	public void attribuerRole(Role role, Long userID);
	//Liste des caisses
	public List<Caisse> listeCaisse();
	//Get Caisse
	public Caisse getCaisse(Long idTransaciotn);
	//Liste des Vente
	public List<Vente> listeVentes();

}
