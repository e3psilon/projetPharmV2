package com.projetPharmV2.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.projetPharmV2.AppPharmApplication;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.metier.UserMetier;
import com.projetPharmV2.metier.util.NotificationUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Controller
public class FXMLDocumentInscriptionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FXMLDocumentInscriptionController.class);
	private UserMetier userMetier;

	@FXML
	private JFXTextField userNameField;
	private String nomUtilisateur;

	@FXML
	private JFXTextField nomUserField;
	private String nom;

	@FXML
	private JFXTextField prenomUserField;
	private String prenom;

	@FXML
	private JFXTextField telephoneUserField;
	private String telephone;

	@FXML
	private JFXPasswordField passwordField;
	private String motDePasse;

	@FXML
	private JFXPasswordField passwordConfirmationField;
	private String motDePasseConfirmation;

	@FXML
	private JFXButton inscription;

	@FXML
	private JFXButton reset;

	@FXML
	void Inscription(ActionEvent event) {
		LOGGER.info("Acces a la fonction inscription");
		User user = getFieldFormulaireInscription();
		if (user != null) {
			LOGGER.info("control champs ok");
			LOGGER.info("getUserMetierBean");
			getUserMetierBean();
			try {
				user = userMetier.saveUser(user);
				NotificationUtil.NotificationInscriptionOK();
				resetAllField();
				redirectLogin(event);
			} catch (Exception e) {
				NotificationUtil.NotificationERRORInatendue();
			}

		}

	}

	@FXML
	void reset(ActionEvent event) {
		LOGGER.info("Reset des champs Inscription");
		resetAllField();

	}

	/**
	 * Fonction qui reset les champs du formulaire
	 */
	private void resetAllField() {
		restAllFild();

	}

	private void restAllFild() {
		userNameField.clear();
		nomUserField.clear();
		prenomUserField.clear();
		telephoneUserField.clear();
		passwordField.clear();
		passwordConfirmationField.clear();
	}

	/**
	 * Fonction qui get les champs du formulaire
	 */
	private User getFieldFormulaireInscription() {
		User user = new User();
		LOGGER.info("get tout les champs formulaire");
		nomUtilisateur = userNameField.getText();
		nom = nomUserField.getText();
		prenom = prenomUserField.getText();
		telephone = telephoneUserField.getText();
		motDePasse = passwordField.getText();
		motDePasseConfirmation = passwordConfirmationField.getText();
		LOGGER.info("control de tout les champs formulaire");
		if (StringUtils.isEmpty(nomUtilisateur) || StringUtils.isEmpty(nom) || StringUtils.isEmpty(prenom)
				|| StringUtils.isEmpty(telephone) || StringUtils.isEmpty(motDePasse)
				|| StringUtils.isEmpty(motDePasseConfirmation)) {
			LOGGER.info("Notification champ OBligatoire");
			NotificationUtil.NotificationTousChampObligatoire();
			return null;
		}
		if (!motDePasse.equals(motDePasseConfirmation)) {
			LOGGER.info("control du mot de passe est confirmation");
			NotificationUtil.MotdePasseEtConfirmationIncorrect();
			passwordField.clear();
			passwordConfirmationField.clear();
			return null;

		}
		return construirUser(user);

	}

	/**
	 * Fonction qui constuit le user du formulair
	 *
	 * @param user
	 * @return
	 */

	private User construirUser(User user) {
		LOGGER.info("Construction de l'utilisateur");
		user.setNomUser(nom);
		user.setPrenomUser(prenom);
		user.setUserName(nomUtilisateur);
		user.setTelephone(telephone);
		user.setPassword(motDePasse);
		user.setActived(false);
		return user;
	}

	@FXML
	void makeLogin(ActionEvent event) throws IOException {
		redirectLogin(event);
		LOGGER.info("Redirection vers la page Login");

	}

	/**
	 * Fonction qui redirige vers la page login
	 *
	 * @param event
	 * @throws IOException
	 */
	private void redirectLogin(ActionEvent event) throws IOException {
		LOGGER.info("Redirection vers la page Login");
			Parent adminParent = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentLogin.fxml"));
			Scene adminScene = new Scene(adminParent);
			Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			adminStage.hide();
			adminStage.setScene(adminScene);
			adminStage.setTitle("Login");
			adminStage.show();
			LOGGER.info("fin de la redirection vers la page login");


	}

	/**
	 * Fonction qui get le bean UserMetier
	 *
	 */
	private void getUserMetierBean() {
		LOGGER.info("get Bean UserMetier");
		userMetier = AppPharmApplication.applicationContext.getBean(UserMetier.class);

	}

}
