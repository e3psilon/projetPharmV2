package com.projetPharmV2.controller;

import javax.management.Notification;

import org.springframework.util.StringUtils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.projetPharmV2.AppPharmApplication;
import com.projetPharmV2.entities.Client;
import com.projetPharmV2.metier.ClientMetier;
import com.projetPharmV2.metier.util.NotificationUtil;

import fr.jcgay.notification.Notifier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentAdminControllerAddClient {
	@FXML
	private AnchorPane anchorPaneCreationClient;

	@FXML
	private JFXTextField numSecuField;
	private String numSecu;

	@FXML
	private JFXTextField nomClientField;
	private String nomClient;

	@FXML
	private JFXTextField prenomClientField;
	private String prenomClient;

	@FXML
	private JFXTextField telephoneClientField;
	private String telephoneClient;

	@FXML
	private JFXTextField adressClientField;
	private String adressClient;

	@FXML
	private JFXButton enregister;

	@FXML
	private JFXButton reset;

	@FXML
	private JFXButton annuler;

	private ClientMetier clientMetier;

	@FXML
	void addClient(ActionEvent event) {
		clientMetier = getClientMetierBean();
		getChampsFormulaire();
		controlChamp();
	}

	private Client controlChamp() {
		if (StringUtils.isEmpty(numSecu)||StringUtils.containsWhitespace(numSecu) || StringUtils.isEmpty(nomClient) || StringUtils.isEmpty(prenomClient)) {
			//int count = numSecu.length();
			//taille du numero de secu
			NotificationUtil.NotificationTousChampObligatoire();
			//Notification info = new Notification("Title", "Info-Message");
			//Notifier.INSTANCE.notify(info);
		}else {
			NotificationUtil.NotificationInscriptionOK();
			return clientMetier.saveClient(new Client(Long.parseLong(numSecu), nomClient, prenomClient, adressClient, telephoneClient));
		}
		return null;
	}

	private void getChampsFormulaire() {
		numSecu = numSecuField.getText();
		nomClient = nomClientField.getText();
		prenomClient = prenomClientField.getText();
		telephoneClient =telephoneClientField.getText();
		adressClient = adressClientField.getText();

	}

	private ClientMetier getClientMetierBean() {
		return AppPharmApplication.applicationContext.getBean(ClientMetier.class);
	}

	@FXML
	void makeRetour(ActionEvent event) {

	}

	@FXML
	void resetClient(ActionEvent event) {

	}
}
