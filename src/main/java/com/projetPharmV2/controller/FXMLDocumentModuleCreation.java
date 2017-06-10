package com.projetPharmV2.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLDocumentModuleCreation implements Initializable {
	private AnchorPane cerationClient;
	@FXML
	private Pane moduleCreation;

	@FXML
	private JFXButton creatUtilisat;

	@FXML
	private JFXButton creatClt;

	@FXML
	void creatClient(ActionEvent event) {
		creatUtilisat.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
		creatClt.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
	}

	@FXML
	void creatUtilisateur(ActionEvent event) {
		creatUtilisat.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
		creatClt.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		creatUtilisat.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
		creatClt.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8

	}

}
