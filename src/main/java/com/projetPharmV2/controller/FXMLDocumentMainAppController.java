/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetPharmV2.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.projetPharmV2.metier.util.TrayNotification;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class FXMLDocumentMainAppController implements Initializable {

	/**
	 * Initializes the controller class.
	 */
	@FXML
	private Label labelName;

	VBox sidePane;
	@FXML
	private JFXHamburger ham;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private JFXComboBox depCombo;
	@FXML
	private Label panel;
	TrayNotification tray;
	@FXML
	private SplitMenuButton splitMenuButton;

	@FXML
	private MenuItem monCompte;

	@FXML
	private MenuItem logout;

	@FXML
	void logout(ActionEvent event) throws IOException {
		redirection(event);

	}

	private void redirection(ActionEvent event) throws IOException {
		// Node node= (Node)event.getSource();
		anchorPane = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentMainAppView.fxml"));
		// FXMLDocumentControllerUtils.redirection(anchorPane, event, "");
		Scene adminScene = new Scene(anchorPane);
		Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		adminStage.hide();
		adminStage.setScene(adminScene);
		adminStage.setTitle("admin");
		adminStage.show();
		// LOGGER.info("fin de la redirection vers la page ");

	}

	@FXML
	void monCompte(ActionEvent event) {
		Pane panReglage;
		try {
			AnchorPane mettreAjourProfil = FXMLLoader
					.load(getClass().getResource("/view/FXMLDocumentAdminMettreAjourProfil.fxml"));
			AnchorPane MettreAjourPassword = FXMLLoader
					.load(getClass().getResource("/view/FXMLDocumentAdminMettreAjourPassword.fxml"));
			panReglage = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentModulReglage.fxml"));
			mettreAjourProfil.getChildren().add(panReglage);
			setNode(mettreAjourProfil);
			selectionReglage(mettreAjourProfil, MettreAjourPassword, panReglage);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

	}

	@FXML
	public void showDrawer(MouseEvent me) {
		if (!drawer.isShown()) {
			drawer.open();
		} else {
			drawer.isShown();
		}
	}

	@FXML
	public void hideDrawer(MouseEvent me) {
		drawer.close();
	}

	public void setNode(Node node) {
		/*
		 * AudioClip notifyMe = new
		 * AudioClip((getClass().getResource("Notify.wav")).toString());
		 * notifyMe.play();
		 */
		/*
		 * tray = new TrayNotification(); tray.setTitle("Congratulations");
		 * tray.setMessage("You have opened the form");
		 * tray.setNotificationType(NotificationType.SUCCESS);
		 * tray.showAndDismiss(Duration.millis(1500));
		 */
		anchorPane.getChildren().clear();
		anchorPane.getChildren().add((Node) node);

		FadeTransition ft = new FadeTransition(Duration.millis(1500));
		ft.setNode(node);
		ft.setFromValue(0.1);
		ft.setToValue(1);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		labelName.setText(" Bonjour : " + FXMLDocumentLoginController.getUser.getNomUser() + " "
				+ FXMLDocumentLoginController.getUser.getPrenomUser());
		panel.setText("");

		try {
			sidePane = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentDrawerView.fxml"));
			AnchorPane loginPane = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentLogin.fxml"));
			AnchorPane ajoutClient = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentAdminAddClient.fxml"));
			// Pane
			// panCreation=FXMLLoader.load(getClass().getResource("/view/FXMLDocumentModuleCreation.fxml"));
			AnchorPane ajoutUtilisateur = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentAjoutUser.fxml"));

			AnchorPane envoiMail = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentMail.fxml"));
			AnchorPane listeUtilisateur = FXMLLoader
					.load(getClass().getResource("/view/FXMLDocumentAdminListeUser.fxml"));
			AnchorPane listeClient = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentListeClient.fxml"));
			//AnchorPane mettreAjourProfil = FXMLLoader
			//		.load(getClass().getResource("/view/FXMLDocumentAdminMettreAjourProfil.fxml"));
			//AnchorPane MettreAjourPassword = FXMLLoader
			//		.load(getClass().getResource("/view/FXMLDocumentAdminMettreAjourPassword.fxml"));
			AnchorPane vente = FXMLLoader
					.load(getClass().getResource("/view/FXMLDocumentVente.fxml"));

			drawer.setSidePane(sidePane);
			// splitMenuButton.addEventHandler(Menu.ON_SHOWN, event
			// ->splitMenuButton.hide());
			// splitMenuButton.addEventHandler(Menu.ON_SHOWING, event
			// ->splitMenuButton.fire());

			for (Node node : sidePane.getChildren()) {
				if (node.getAccessibleText() != null) {
					node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

						switch (node.getAccessibleText()) {
						case ("listeTableauBtn"):
							Pane panListTableau;
							try {
								panListTableau = FXMLLoader
										.load(getClass().getResource("/view/FXMLDocumentModuleListeTableau.fxml"));
								drawer.close();
								panel.setText("Lister");
								listeUtilisateur.getChildren().add(panListTableau);
								setNode(listeUtilisateur);
								selectionPanelListTableau(listeUtilisateur, listeClient, panListTableau);
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}

							break;
						case ("venteBtn"):
							drawer.close();
							panel.setText("Vente PANEL");
							 setNode(vente);
							break;
						case ("reportBtn"):
							drawer.close();
							panel.setText("Envoyer un mail");
							setNode(envoiMail);
							break;
						case ("creationBtn"):
							Pane panCreation;
							try {
								panCreation = FXMLLoader
										.load(getClass().getResource("/view/FXMLDocumentModuleCreation.fxml"));
								drawer.close();
								panel.setText("Enregistrer");
								ajoutUtilisateur.getChildren().add(panCreation);
								setNode(ajoutUtilisateur);
								selectionPanel(ajoutUtilisateur, ajoutClient, panCreation);

							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							break;
						case ("exitBtn"):

							System.exit(0);
							break;

						}
					});
				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		/*
		 * HamburgerSlideCloseTransition transition=new
		 * HamburgerSlideCloseTransition(ham); transition.setRate(-1);
		 * ham.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{
		 * transition.setRate(transition.getRate()*-1); transition.play();
		 */

	}

	private void selectionReglage(AnchorPane mettreAjourProfil, AnchorPane mettreAjourPassword, Pane panReglage) {
		for (Node node : panReglage.getChildren()) {
			if (node.getAccessibleText() != null) {
				node.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> {
					switch (node.getAccessibleText()) {
					case ("updateProfil"):
						mettreAjourProfil.getChildren().add(panReglage);
						setNode(mettreAjourProfil);
						break;
					case ("changePassword"):
						mettreAjourPassword.getChildren().add(panReglage);
						setNode(mettreAjourPassword);
						break;
					default:
						break;
					}
				});
			}
		}

	}

	private void selectionPanelListTableau(AnchorPane listeUtilisateur, AnchorPane listeClient, Pane panListTableau) {
		for (Node node : panListTableau.getChildren()) {
			if (node.getAccessibleText() != null) {
				node.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> {
					switch (node.getAccessibleText()) {
					case ("listeUser"):
						listeUtilisateur.getChildren().add(panListTableau);
						setNode(listeUtilisateur);
						break;
					case ("listeClient"):
						listeClient.getChildren().add(panListTableau);
						setNode(listeClient);
						break;

					default:
						break;
					}
				});
			}
		}

	}

	private void selectionPanel(AnchorPane ajoutUtilisateur, AnchorPane ajoutClient, Pane panCreation) {
		for (Node node : panCreation.getChildren()) {
			if (node.getAccessibleText() != null) {
				node.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> {

					switch (node.getAccessibleText()) {
					case ("creationUtilisateur"):

						ajoutUtilisateur.getChildren().add(panCreation);
						setNode(ajoutUtilisateur);

						break;
					case ("creationClient"):
						ajoutClient.getChildren().add(panCreation);
						setNode(ajoutClient);
						break;

					default:
						break;
					}

				});
			}
		}

	}

}
