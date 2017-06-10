package com.projetPharmV2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class FXMLDocumentModuleListTabeleau implements Initializable {
	@FXML
	private Pane headr;

	@FXML
	private TextField txt_search;

	@FXML
	private JFXButton listeUtilisateurs;

	@FXML
	private JFXButton listeClients;

	@FXML
	private JFXButton listesVentes;

	@FXML
	private JFXButton caisses;

	@FXML
	void caisses(ActionEvent event) {
		listeUtilisateurs.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
		listeClients.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
		listesVentes.setStyle("-fx-background-color: #2e53b8");
		caisses.setStyle("-fx-background-color: #1C26B3");
	}

	@FXML
	void listeClients(ActionEvent event) {
		listeClients.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
		listeUtilisateurs.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
		listesVentes.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
		caisses.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
	}

	@FXML
	void listeUtilisateurs(ActionEvent event) {
		listeUtilisateurs.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
		listeClients.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
		listesVentes.setStyle("-fx-background-color: #2e53b8");
		caisses.setStyle("-fx-background-color: #2e53b8");

	}

	@FXML
	void listesVentes(ActionEvent event) {
		listeUtilisateurs.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
		listeClients.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
		listesVentes.setStyle("-fx-background-color: #1C26B3");
		caisses.setStyle("-fx-background-color: #2e53b8");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listeUtilisateurs.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
		listeClients.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
		listesVentes.setStyle("-fx-background-color: #2e53b8");
		caisses.setStyle("-fx-background-color: #2e53b8");

	}

}
