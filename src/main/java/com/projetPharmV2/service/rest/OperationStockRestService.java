package com.projetPharmV2.service.rest;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetPharmV2.metier.OperationStockMetier;

//@RestController
public class OperationStockRestService {
	@Autowired
	private OperationStockMetier operationStockMetier;
	//@RequestMapping(value="/operation",method=RequestMethod.PUT)
	//public void AjouterStockt(@RequestBody User user,@RequestBody Produit produit,@RequestBody Categorie categorie) {
	//	operationStockMetier.AjouterStockt(user, produit, categorie);
	//}

}
