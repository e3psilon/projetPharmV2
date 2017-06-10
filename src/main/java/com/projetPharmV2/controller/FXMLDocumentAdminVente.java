package com.projetPharmV2.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.entities.Vente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class FXMLDocumentAdminVente implements Initializable{
	@FXML
    private JFXButton editVente;

    @FXML
    private JFXButton deleteVente;

    @FXML
    private JFXButton makeUpdateVente;

    @FXML
    private JFXButton retour;

    @FXML
    private TableView<Vente> tableUser;

    @FXML
    private TableColumn<Vente, Long> colIDVente;

    @FXML
    private TableColumn<Vente, Long> colNir;

    @FXML
    private TableColumn<Vente, Date> colDateVente;

    @FXML
    private TableColumn<User, String> colNomVendeur;

    @FXML
    private TableColumn<User, String> colPrenomVendeur;

    @FXML
    private Pane panListerTableau;

    @FXML
    void getAllUser(MouseEvent event) {

    }

    @FXML
    void makeAddUser(ActionEvent event) {

    }

    @FXML
    void makeDeleteVente(ActionEvent event) {

    }

    @FXML
    void makeGetAllUser(ActionEvent event) {

    }

    @FXML
    void makeUpdateVente(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
