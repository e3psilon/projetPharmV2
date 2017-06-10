package com.projetPharmV2.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import com.projetPharmV2.AppPharmApplication;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.metier.UserMetier;
import com.projetPharmV2.metier.util.FadeInRightTransition;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ADminTableau {
	private UserMetier userMetier;
	@FXML
	private AnchorPane acMain;

	@FXML
	private Pane panAdmin;

	@FXML
	private TableView<User> tableUser;

	@FXML
	private TableColumn<User, Integer> colNo;

	@FXML
	private TableColumn<User, Integer> colIDUSER;

	@FXML
	private TableColumn<User, Boolean> colActivationUser;
	@FXML
	private TableColumn<User, String> colPseudo;
	@FXML
	private TableColumn<User, String> colNomUser;
	@FXML
	private TableColumn<User, String> colTelUser;
	@FXML
	private TableColumn<User, String> colomPrenomUser;

	@FXML
	private TableColumn<User, String> colProfil;

	@FXML
	private TableColumn<User, Integer> colIDCaisse;

	private ObservableList<User> listTableauFX = FXCollections.observableArrayList();

	@FXML
	private JFXButton addUser;

	@FXML
	private JFXButton updateUser;

	@FXML
	private JFXButton deleteUser;

	@FXML
	private JFXButton refrech;

	@FXML
	private JFXButton enregister;

	@FXML
	private JFXButton editer;

	@FXML
	private Separator AjoutNameUser;

	@FXML
	private JFXButton annuler;

	@FXML
	private JFXToggleButton activerUserFieldDetail;

	@FXML
	private Label textNomLabel = new Label();

	@FXML
	private Label textprenomLabel = new Label();

	@FXML
	private Label textTelephoneLabel = new Label();

	@FXML
	private Label derniereConnexioLabel = new Label();

	@FXML
	private Label textUserNameLabel = new Label();

	public void initialize() {
		remplirTabeleau();
		tableUser.setItems(getAllUser());

	}

	/*****/

	/****/
	private void remplirTabeleau() {
		colIDUSER.setCellValueFactory(new PropertyValueFactory<User, Integer>("idUser"));
		colActivationUser.setCellValueFactory(new PropertyValueFactory<User, Boolean>("Activation"));
		colPseudo.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
		colNomUser.setCellValueFactory(new PropertyValueFactory<User, String>("nomUser"));
		colomPrenomUser.setCellValueFactory(new PropertyValueFactory<User, String>("prenomUser"));
		colTelUser.setCellValueFactory(new PropertyValueFactory<User, String>("telephone"));
		Button edit = new Button("Edit");

	}

	// Fonction Get All User
	private ObservableList<User> getAllUser() {
		getUserMetierBean();

		listTableauFX = FXCollections.observableArrayList(userMetier.listeUser());
		return listTableauFX;
	}

	private void getUserMetierBean() {
		userMetier = AppPharmApplication.applicationContext.getBean(UserMetier.class);

	}

	@FXML
	void acMain(KeyEvent event) {
		initialize();
	}

	@FXML
	void acMainOnMouseMove(MouseEvent event) {

	}

	@FXML
	void getAllUser(MouseEvent event) throws IOException {
		panAdmin.setEffect(new GaussianBlur(10));
		new FadeInRightTransition(panAdmin).play();
		Object object = tableUser.getSelectionModel().selectedItemProperty().get();
		User user = (User) object;
		remplirChampsGetUserAndUpdate(user);
		Stage stage = new Stage();
		Parent parent = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentGetUserAndUpdate.fxml"));
		stage.setScene(new Scene(parent));
		stage.setTitle("My modal window");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
		stage.show();
	}

	private void remplirChampsGetUserAndUpdate(User user) {
		textUserNameLabel.setText(user.getUserName());
		textNomLabel.setText(user.getNomUser());
		textprenomLabel.setText(user.getPrenomUser());
		textTelephoneLabel.setText(user.getTelephone());
		// if(user.isActived()) {
		// activerUserFieldDetail.setText("Utilisateur activé");
		// activerUserFieldDetail.setToggleColor(javafx.scene.paint.Color.valueOf("#4864b9"));
		// activerUserFieldDetail.setToggleLineColor(javafx.scene.paint.Color.valueOf("#6c87d7"));
		// activerUserFieldDetail.setUnToggleColor(javafx.scene.paint.Color.valueOf("#fafafa"));
		// activerUserFieldDetail.setToggleLineColor(javafx.scene.paint.Color.valueOf("#999999"));
		// }
	}

	@FXML
	void makeAddUser(ActionEvent event) throws IOException {

		panAdmin.setEffect(new GaussianBlur(10));
		new FadeInRightTransition(panAdmin).play();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentAjoutUser.fxml"));
		stage.setScene(new Scene(root));
		stage.setTitle("My modal window");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
		stage.show();

	}

	@FXML
	void makeGetAllUser(ActionEvent event) {

	}

	@FXML
	void makeUpdateUser(ActionEvent event) {

	}

	/*
	 * private void loading (){ Service<Void> service; service = new
	 * Service<Void>() {
	 *
	 * @Override protected Task<Void> createTask() { return new Task<Void>() {
	 *
	 * @Override protected Void call() throws InterruptedException {
	 * updateMessage("Loading Data . . ."); updateProgress(0, 100); for (int i =
	 * 0; i < 100; i++) { Thread.sleep(70); updateProgress(i + 1, 100);
	 * updateMessage("Loading " + (i + 1) + "%"); } updateMessage("Found all.");
	 * return null; } }; } }; Dialogs.create() .owner(stage)
	 * .title("Please Wait") .masthead("Searching From Database")
	 * .showWorkerProgress(service); service.start(); }
	 *
	 */

	@FXML
	void makeDeleteUser(ActionEvent event) {

	}

	@FXML
	void activerUtilisateur(ActionEvent event) {

	}

	@FXML
	void addUser(ActionEvent event) {

	}

	@FXML
	void editer(ActionEvent event) {

	}

	@FXML
	void makeRetour(ActionEvent event) {

	}

}
