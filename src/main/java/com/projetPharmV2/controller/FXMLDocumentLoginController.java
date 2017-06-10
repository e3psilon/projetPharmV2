package com.projetPharmV2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.projetPharmV2.AppPharmApplication;
import com.projetPharmV2.entities.Role;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.metier.RoleMetier;
import com.projetPharmV2.metier.UserMetier;
import com.projetPharmV2.metier.util.NotificationUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import javafx.stage.Screen;
import javafx.stage.Stage;

@Controller
public class FXMLDocumentLoginController implements Initializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(FXMLDocumentLoginController.class);

	private UserMetier userMetier;

	private String utilisateur;

	private String motDePasse;

	public static User getUser;

	@FXML
	private JFXTextField user;

	@FXML
	private JFXPasswordField password;

	@FXML
	private JFXButton login;

	@FXML
	private JFXButton signUp;

	/**
	 * Action Inscription
	 *
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void inscription(ActionEvent event) {
		try {
			Parent adminParent = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentInscription.fxml"));
			Scene adminScene = new Scene(adminParent);
			Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			adminStage.hide();
			adminStage.setScene(adminScene);
			adminStage.setTitle("Inscription");
			adminStage.show();
		} catch (IOException e) {
			NotificationUtil.NotificationERRORInatendue();
		}

	}

	/**
	 * Action Login
	 *
	 * @param event
	 */
	@FXML
	void makeLogin(ActionEvent event) {
		LOGGER.info("Action Login");
		getFieldUserAndPassword();
		getUserMetier();
		LOGGER.info("Requete User/mot de passe");
		getUser = userMetier.findOneUserByUserNameAndPassword(utilisateur, motDePasse);

		if (getUser == null) {
			LOGGER.info("user Null: Notification user*, passe*--->utilisateur introuvable");
			NotificationUtil.alert(AlertType.ERROR, "Erreur Authentification",
					"Nom utilisateur ou mot de passe incorrect");
			// NotificationMotDePasseIncorrect();
		} else {
			// if (isMotdePasseValide(getUser, utilisateur, motDePasse)) {
			LOGGER.info("user ok/pass ok--->Notification valide");
			NotificationValidAndConnexion();

			try {
				redirection(getUser, event);
			} catch (IOException e) {
				NotificationUtil.NotificationERRORInatendue();
			}

		}
	}

	/**
	 * Fonction de redirection vers la page Admin ou utilisateur
	 *
	 * @param getUser
	 * @param event
	 * @throws IOException
	 */
	private void redirection(User getUser, ActionEvent event) throws IOException {
		Parent parent = null;
		RoleMetier roleMetier = getBeanRole();
		Role role = roleMetier.findOneRole(getUser.getIdUser());

		switch (role.getRoleName()) {
		case ("ADMIN"):
			parent = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentMainAppView.fxml"));
			redirectionFonction(parent, event);
			 AudioClip au = new
			 AudioClip(getClass().getResource("/audio/Notify.wav").toString());
			 au.play();
			break;
		case ("USER"):
			parent = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentUser.fxml"));
			redirectionFonction(parent, event);
			break;

		default:
			break;
		}

	}

	private RoleMetier getBeanRole() {
		return AppPharmApplication.applicationContext.getBean(RoleMetier.class);

	}

	private void redirectionFonction(Parent parent, ActionEvent event) {
		Scene adminScene = new Scene(parent);
		Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		adminStage.setX(bounds.getMinX());
		adminStage.setY(bounds.getMinY());
		adminStage.setWidth(bounds.getWidth());
		adminStage.setHeight(bounds.getHeight());
		adminStage.hide();
		adminStage.setScene(adminScene);
		adminStage.setTitle("Projet Pahrm V2");
		adminStage.show();
		LOGGER.info("fin de la redirection vers la page ");

	}

	/**
	 * Fonction qui control le nom utilisateur et mot de passse
	 *
	 * @param getUser
	 * @param motDePasse
	 * @param utilisateur
	 * @return
	 */
	// private boolean isMotdePasseValide(User getUser, String utilisateur,
	// String motDePasse) {
	// if (getUser.getNomUser().equals(utilisateur) &&
	// getUser.getPassword().equals(utilisateur)) {
	// return true;
	// }
	// return false;
	// }

	/**
	 * Fonction qui retoune une notification d'erreur mot de passe incorrect
	 *
	 */
	private void NotificationMotDePasseIncorrect() {
		NotificationUtil.NotificationMotDePasseIncorrect();

		user.clear();
		password.clear();
	}

	/**
	 * Fonction qui retourne une Notification Connexion
	 */
	private void NotificationValidAndConnexion() {
		NotificationUtil.NotificationValidAndConnexion();
	}

	/**
	 * Fonction qui get les champs utilisateur et mot de passe
	 */
	private void getFieldUserAndPassword() {
		utilisateur = user.getText();
		motDePasse = password.getText();
		if (StringUtils.isEmpty(utilisateur) || StringUtils.isEmpty(motDePasse)) {
			NotificationUtil.NotificationTousChampObligatoire();
		}

	}

	/**
	 * Fonction qui get le bean UserMetier
	 *
	 */
	private void getUserMetier() {
		LOGGER.info("get Bean UserMetier");
		userMetier = AppPharmApplication.applicationContext.getBean(UserMetier.class);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
