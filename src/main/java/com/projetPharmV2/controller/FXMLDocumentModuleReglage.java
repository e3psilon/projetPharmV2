package com.projetPharmV2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

public class FXMLDocumentModuleReglage implements Initializable {
	@FXML
	private Pane moduleReglage;

	@FXML
	private JFXButton updateProfil;

	@FXML
	private JFXButton changePassword;

	@FXML
	void changePaswword(ActionEvent event) {
		updateProfil.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
		changePassword.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
	}

	@FXML
	void updateProfil(ActionEvent event) {
		updateProfil.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
		changePassword.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateProfil.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
		changePassword.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8

	}

}
