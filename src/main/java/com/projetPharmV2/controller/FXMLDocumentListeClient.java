package com.projetPharmV2.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.projetPharmV2.AppPharmApplication;
import com.projetPharmV2.entities.Client;
import com.projetPharmV2.metier.ClientMetier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class FXMLDocumentListeClient implements Initializable{
	private ClientMetier clientMetier;
	private List<Client> listeClient;
	private ObservableList<Client> listTableauClientFX = FXCollections.observableArrayList();
	@FXML
    private JFXButton addClient;

    @FXML
    private JFXButton deleteClient;

    @FXML
    private JFXButton makeUpdateClient;

    @FXML
    private JFXButton retour;

    @FXML
    private TableView<Client> tableClient;

    @FXML
    private TableColumn<Client, Long> colIDClient;

    @FXML
    private TableColumn<Client, String> colNomClient;

    @FXML
    private TableColumn<Client, String> colomPrenomClient;

    @FXML
    private TableColumn<Client, String> colTelClient;

    @FXML
    private TableColumn<Client, String> colAdress;

    @FXML
    private Pane panListerTableau;

    @FXML
    void getAllUser(MouseEvent event) {

    }

    @FXML
    void makeDeleteClient(ActionEvent event) {

    }

    @FXML
    void makeEditClient(ActionEvent event) {

    }

    @FXML
    void makeHome(ActionEvent event) {

    }

    @FXML
    void makeUpdateClient(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tableClient.setItems( getAllClient());
		remplirTableau();
	}



		// Fonction Get All Client
		private ObservableList<Client> getAllClient() {
			getClientMetierBean();
			listeClient = clientMetier.listeClient();

			listTableauClientFX = FXCollections.observableArrayList(listeClient);
			return listTableauClientFX;
		}

		private void getClientMetierBean() {
			clientMetier = AppPharmApplication.applicationContext.getBean(ClientMetier.class);

		}
		private void remplirTableau() {
			colIDClient.setCellValueFactory(new PropertyValueFactory<Client,Long>("nir"));
			colNomClient.setCellValueFactory(new PropertyValueFactory<Client,String>("nomClient"));
			colomPrenomClient.setCellValueFactory(new PropertyValueFactory<Client,String>("prenomClient"));
			colTelClient.setCellValueFactory(new PropertyValueFactory<Client,String>("telephoneClient"));
			colAdress.setCellValueFactory(new PropertyValueFactory<Client,String>("adresseClient"));

		}

}
