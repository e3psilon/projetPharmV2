package com.projetPharmV2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.util.StringUtils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import com.jfoenix.controls.JFXPasswordField;
import com.projetPharmV2.AppPharmApplication;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.metier.UserMetier;
import com.projetPharmV2.metier.util.NotificationUtil;

import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class FXMLDocumentAdminUpdatePassword implements Initializable {
	public static final String CONTENT_PANE = "ContentPane";
	@FXMLViewFlowContext
	private ViewFlowContext context;
	@FXML
	private JFXPasswordField ancienMotPasseField;
	private String ancienMotPasse;

	@FXML
	private JFXPasswordField newMotPasseField;
	private String newMotPasse;

	@FXML
	private JFXPasswordField confirmationMotPassField;
	private String confirmationMotPasse;

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
	void mettreAjourPassword(ActionEvent event) throws IOException {

		User user = FXMLDocumentLoginController.getUser;
		getChampFormulaire();
		if (!(user.getPassword().equals(ancienMotPasse))) {
			NotificationUtil.alert(AlertType.ERROR, "Erreur", "Ancien mot de passe incorrect");
			ancienMotPasseField.clear();
		}
		if ((user.getPassword().equals(ancienMotPasse)) && !(StringUtils.isEmpty(newMotPasse))
				&& !(StringUtils.isEmpty(confirmationMotPasse)) && newMotPasse.equals(confirmationMotPasse)) {
			if (ancienMotPasse.equals(newMotPasse)) {
				NotificationUtil.alert(AlertType.ERROR, "Erreur",
						"le nouveau mot de passe doit être different de l'ancien mot de passe");
				newMotPasseField.clear();
				confirmationMotPassField.clear();
			} else {
				user.setPassword(newMotPasse);
				getBeanUser();
				userMetier.saveUser(user);
				NotificationUtil.alert(AlertType.INFORMATION, "Confirmation", "Operation effectué");
				redirection(event);
			}
		}
	}

	private void getBeanUser() {
		userMetier = AppPharmApplication.applicationContext.getBean(UserMetier.class);
	}

	private void getChampFormulaire() {
		ancienMotPasse = ancienMotPasseField.getText();
		newMotPasse = newMotPasseField.getText();
		confirmationMotPasse = confirmationMotPassField.getText();

	}

	@FXML
	void makeRetour(ActionEvent event) throws IOException {
		redirection(event);
	}

	@FXML
	void reset(ActionEvent event) {
		ancienMotPasseField.clear();
		newMotPasseField.clear();
		confirmationMotPassField.clear();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	private void redirection(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentMainAppView.fxml"));
		FXMLDocumentControllerUtils.redirection(parent, event, "");

	}

	private void bindNodeToController(Node node, Class<?> controllerClass, Flow flow, FlowHandler flowHandler) {
		flow.withGlobalLink(node.getId(), controllerClass);
	}
}
