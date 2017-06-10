/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetPharmV2.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class FXMLDocumentDrawerController implements Initializable {

	/**
	 * Initializes the controller class.
	 */
	@FXML
	private JFXButton exit;

	@FXML
	private JFXButton vente;

	@FXML
	private JFXButton register;

	@FXML
	private JFXButton attendance;

	@FXML
	private JFXButton report;
	@FXML
	private JFXButton Statistique;

	@FXML
	public void close(ActionEvent ae) {
		System.exit(0);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Image imageStorage = new Image(getClass().getResource("/icon/storage_5.png").toExternalForm(), 80, 80, true,
				true);
		register.setGraphic(new ImageView(imageStorage));
		Image imageListe = new Image(getClass().getResource("/icon/tableau-system-config.png").toExternalForm(), 80, 80,
				true, true);
		attendance.setGraphic(new ImageView(imageListe));
		Image imageMail = new Image(getClass().getResource("/icon/send-mail-circle-128.png").toExternalForm(), 80, 80,
				true, true);
		report.setGraphic(new ImageView(imageMail));
	}

}
