package com.projetPharmV2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.projetPharmV2.entities.Categorie;
import com.projetPharmV2.metier.VendeurMetier;



//@Controller
//@RequestMapping(value="/adminCat")
//@RestController
public class VendeurController {
	@Autowired
	private VendeurMetier vendeurMetier;
	private String welcomeMessage = "Populated by JSF created bean";

	//@RequestMapping(value="/categorie")
	public String index(Model model ) {
		model.addAttribute("categorie", new Categorie());
		//model.addAttribute("getCategorie", vendeurMetier.getCategorie(1L));
		model.addAttribute("categories",vendeurMetier.listeCategorie());
		return "categories";
	}
	//@CrossOrigin(origins="http://localhost:3000")
	//@RequestMapping(value="/categories",method=RequestMethod.GET)
	public List<Categorie> listeCaisse() {
		return vendeurMetier.listeCategorie();
	}

	public String getMessage(){
		return welcomeMessage;
	}

}
