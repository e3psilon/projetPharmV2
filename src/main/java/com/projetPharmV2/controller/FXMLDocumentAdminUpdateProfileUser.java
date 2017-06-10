package com.projetPharmV2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.util.StringUtils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.projetPharmV2.AppPharmApplication;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.metier.UserMetier;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class FXMLDocumentAdminUpdateProfileUser implements Initializable {
	@FXML
	private JFXTextField userNameField;
	private String userName;

	@FXML
	private JFXTextField nomUserField;
	private String nomUser;

	@FXML
	private JFXTextField prenomUserField;
	private String prenomUser;

	@FXML
	private JFXTextField telephoneUserField;
	private String telephoneUser;

	@FXML
	private JFXButton enregister;

	@FXML
	private JFXButton reset;

	@FXML
	private JFXButton annuler;

	@FXML
	private Pane panCreation;

	private UserMetier userMetier;

	@FXML
	void mettreAjourProfil(ActionEvent event) {
		getField();
		getBeanMetier();
		mettreAjourUser();
	}

	private void mettreAjourUser() {
		User user = FXMLDocumentLoginController.getUser;
		if (!user.getUserName().equals(userName)) {
			user.setUserName(userName);
		}
		if (!user.getPrenomUser().equals(prenomUser)) {
			user.setPrenomUser(prenomUser);
		}
		if (!user.getPrenomUser().equals(prenomUser)) {
			user.setPrenomUser(prenomUser);
		}
		if (!user.getNomUser().equals(nomUser)) {
			user.setNomUser(nomUser);
		}
		if (!user.getTelephone().equals(telephoneUser)) {
			user.setTelephone(telephoneUser);
		}
		FXMLDocumentLoginController.getUser = user;
		userMetier.saveUser(user);
	}

	private void getBeanMetier() {
		userMetier = AppPharmApplication.applicationContext.getBean(UserMetier.class);
	}

	private void getField() {
		userName = userNameField.getText();
		nomUser = nomUserField.getText();
		prenomUser = prenomUserField.getText();
		telephoneUser = telephoneUserField.getText();
	}

	@FXML
	void makeRetour(ActionEvent event) throws IOException {
		redirection(event);
	}

	@FXML
	void reset(ActionEvent event) {
		userNameField.clear();
		nomUserField.clear();
		prenomUserField.clear();
		telephoneUserField.clear();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		userNameField.setText(FXMLDocumentLoginController.getUser.getUserName());
		nomUserField.setText(FXMLDocumentLoginController.getUser.getNomUser());
		prenomUserField.setText(FXMLDocumentLoginController.getUser.getPrenomUser());
		telephoneUserField.setText(FXMLDocumentLoginController.getUser.getTelephone());

	}
	private void redirection(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentMainAppView.fxml"));
		FXMLDocumentControllerUtils.redirection(parent, event, "");

	}

}
