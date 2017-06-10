package com.projetPharmV2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.util.StringUtils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.projetPharmV2.AppPharmApplication;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.metier.UserMetier;
import com.projetPharmV2.metier.util.NotificationUtil;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class FXMLDocumentAdminControllerAddUserModal implements Initializable {
	@FXML
    private Pane panCreation;

	@FXML
	AnchorPane anchorPaneCreationClient;
	@FXML
	AnchorPane anchorPaneCreate;
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
	private String telephone;

	@FXML
	private JFXPasswordField passwordField;
	private String password;

	@FXML
	private JFXPasswordField passwordConfirmationField;
	private String passwordConfirmation;
	@FXML
	private JFXToggleButton activerUserField;
	private Boolean activerUser;
	@FXML
	private JFXButton enregister;

	@FXML
	private JFXButton reset;

	@FXML
	private JFXButton annuler;

	private UserMetier userMetier;

	private String title = "";






	//@FXML
	//void creatUtilisateur(ActionEvent event) {
		//setNode(anchorPaneCreate);
		//creatUtilisat.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
		//creatClt.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8

	//}

	@FXML
	void addUser(ActionEvent event) throws IOException {
		getUserMetierBean();
		getFormulaire();
		getChampUser(userMetier, event);
	}

	private void getChampUser(UserMetier userMetier, ActionEvent event) throws IOException {
		if (!StringUtils.isEmpty(userName) && (!StringUtils.isEmpty(nomUser)) && (!StringUtils.isEmpty(password))
				&& (!StringUtils.isEmpty(passwordConfirmation))) {
			if (!(password.equals(passwordConfirmation))) {
				NotificationUtil.NotificationMotDePasseIncorrect();
			} else {
				getchampUserToStore();
				User user = userMetier.findOneUserByUserName(userName);
				if (user != null) {
					NotificationUtil.NotificationERROR("Erreur", "Nom utilisateur existe");
				} else {
					user = getchampUserToStore();
					userMetier.saveUser(user);
					NotificationUtil.NotificationInscriptionOK();
					redirection(event);
				}

			}
		} else {
			NotificationUtil.NotificationTousChampObligatoire();
		}

	}

	private void getFormulaire() {
		userName = userNameField.getText();
		nomUser = nomUserField.getText();
		prenomUser = prenomUserField.getText();
		telephone = telephoneUserField.getText();
		password = passwordField.getText();
		passwordConfirmation = passwordConfirmationField.getText();
	}

	private User getchampUserToStore() {

		return new User(userName, nomUser, prenomUser, password, activerUser, telephone);

	}

	private void redirection(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentMainAppView.fxml"));
		FXMLDocumentControllerUtils.redirection(parent, event, title);

	}

	private void getUserMetierBean() {
		userMetier = AppPharmApplication.applicationContext.getBean(UserMetier.class);
	}

	@FXML
	void makeRetour(ActionEvent event) throws IOException {
		redirection(event);
	}

	@FXML
	void reset(ActionEvent event) {
		userNameField.clear();
		nomUserField.clear();
		telephoneUserField.clear();
		prenomUserField.clear();
		passwordField.clear();
		passwordConfirmationField.clear();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//try {
			//Pane  panCreation=FXMLLoader.load(getClass().getResource("/view/FXMLDocumentModuleCreation.fxml"));
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//try {
			// anchorPaneCreate =
			// FXMLLoader.load(getClass().getResource("/view/FXMLDocumentAjoutUser.fxml"));
			//anchorPaneCreationClient = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentAdminAddClient.fxml"));
			//creatUtilisat.setStyle("-fx-background-color: #1C26B3");// depart #2e53b8
			//creatClt.setStyle("-fx-background-color: #2e53b8");// depart #2e53b8

	//	} catch (IOException e) {
	//		e.printStackTrace();
	//	}

	}

	public void setNode(Node node) {

		// anchorPaneCreate.getChildren().clear();
		// anchorPaneCreate.getChildren().add((Node) node);

		FadeTransition ft = new FadeTransition(Duration.millis(1500));
		ft.setNode(node);
		ft.setFromValue(0.1);
		ft.setToValue(1);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();

	}

	@FXML
	void activerUtilisateur(ActionEvent event) {
		if (activerUserField.getText().equals("Utilisateur désactivé")) {
			activerUserField.setText("Utilisateur activer");
			activerUser = true;
		} else {
			activerUserField.setText("Utilisateur désactivé");
			activerUser = false;

		}

	}

}
