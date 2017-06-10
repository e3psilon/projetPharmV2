package com.projetPharmV2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projetPharmV2.AppPharmApplication;
import com.projetPharmV2.entities.User;
import com.projetPharmV2.metier.UserMetier;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLDocumentAdmin {
	private UserMetier userMetier;

	@FXML
	private StackPane acContent;
	@FXML
	private ScrollPane leftSideBarScroolPan;
	@FXML
	private ToggleButton sideMenuToogleBtn;
	@FXML
	private ImageView imgMenuBtn;
	@FXML
	private BorderPane appContent;
	@FXML
	private Button btnLogOut;
	@FXML
	private MenuItem miPopOver;
	@FXML
	private AnchorPane acDashBord;
	@FXML
	private AnchorPane acHead;
	@FXML
	private AnchorPane acMain;
	@FXML
	private MenuButton mbtnUsrInfoBox;
	@FXML
	private Button btnHome;
	@FXML
	private ImageView imgHomeBtn;
	@FXML
	private Button btnStore;
	@FXML
	private ImageView imgStoreBtn;
	@FXML
	private Button btnEmplopye;
	@FXML
	private ImageView imgEmployeBtn;
	@FXML
	private Button btnSell;
	@FXML
	private ImageView imgSellBtn;
	@FXML
	private Button btnSettings;
	@FXML
	private ImageView imgSettingsBtn;
	@FXML
	private Button btnAbout;
	@FXML
	private ImageView imgAboutBtn;
	@FXML
	private Label lblUsrName;
	@FXML
	private Label lblUsrNamePopOver;
	@FXML
	private Label lblFullName;
	@FXML
	private Label lblRoleAs;
	@FXML
	private Hyperlink hlEditUpdateAccount;
	@FXML
	private Circle imgUsrTop;
	@FXML
	private Circle circleImgUsr;
	@FXML
	private Label lblUserId;

	@FXML
	private ObservableList<User> listTableauFX = FXCollections.observableArrayList();
	@FXML
	private TextField fildRecherche;

	@FXML
	private TableView<User> tableUser;

	@FXML
	private TableColumn<User, Integer> colNo, colIDUser, colIDCaisse;

	@FXML
	private TableColumn<User, Boolean> colActivationUser;

	@FXML
	private TableColumn<User, String> colNomUser, colomPrenomUser, colProfil, colTelUser;

	String usrName;
	String id;

	Image menuImage = new Image("/icon/menu.png");
	Image menuImageRed = new Image("/icon/menuRed.png");
	Image image;

	String defultStyle = "-fx-border-width: 0px 0px 0px 5px;" + "-fx-border-color:none";

	String activeStyle = "-fx-border-width: 0px 0px 0px 5px;" + "-fx-border-color:#FF4E3C";

	Image home = new Image("/icon/home.png");
	Image homeRed = new Image("/icon/homeRed.png");
	Image stock = new Image("/icon/stock.png");
	Image stockRed = new Image("/icon/stockRed.png");
	Image sell = new Image("/icon/sell2.png");
	Image sellRed = new Image("/icon/sell2Red.png");
	Image employee = new Image("/icon/employe.png");
	Image employeeRed = new Image("/icon/employeRed.png");
	Image setting = new Image("/icon/settings.png");
	Image settingRed = new Image("/icon/settingsRed.png");
	Image about = new Image("/icon/about.png");
	Image aboutRed = new Image("/icon/aboutRed.png");

	/**
	 * Initializes the controller class.
	 *
	 * @param url
	 * @param rb
	 */
	public void initialize(URL url, ResourceBundle rb) {
		imgMenuBtn.setImage(menuImage);
		Image usrImg = new Image("/image/rifat.jpg");

		imgUsrTop.setFill(new ImagePattern(usrImg));
		circleImgUsr.setFill(new ImagePattern(usrImg));
		remplirTabeleau();
		tableUser.setItems(getAllUser());
		// loading();
		// tableUser.getItems().setAll(getAllUser());

	}

	private void remplirTabeleau() {
		colIDUser.setCellValueFactory(new PropertyValueFactory<User, Integer>("ID"));
		colActivationUser.setCellValueFactory(new PropertyValueFactory<User, Boolean>("Activation"));
		colNomUser.setCellValueFactory(new PropertyValueFactory<User, String>("Nom"));
		colomPrenomUser.setCellValueFactory(new PropertyValueFactory<User, String>("Prenom"));
		colTelUser.setCellValueFactory(new PropertyValueFactory<User, String>("Tel"));

	}

	// Fonction Get All User
	private ObservableList<User> getAllUser() {

		userMetier = AppPharmApplication.applicationContext.getBean(UserMetier.class);
		listTableauFX = FXCollections.observableArrayList(userMetier.listeUser());
		return listTableauFX;
	}

	@FXML
	private void sideMenuToogleBtnOnCLick(ActionEvent event) throws IOException {
		if (sideMenuToogleBtn.isSelected()) {
			imgMenuBtn.setImage(menuImageRed);
			TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
			sideMenu.setByX(-130);
			sideMenu.play();
			acDashBord.getChildren().clear();
		} else {
			imgMenuBtn.setImage(menuImage);
			TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), acDashBord);
			sideMenu.setByX(130);
			sideMenu.play();
			acDashBord.getChildren().add(leftSideBarScroolPan);
		}
	}

	@FXML
	private void btnLogOut(ActionEvent event) throws IOException {
		acContent.getChildren().clear();
		acContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Login.fxml")));
		acDashBord.getChildren().clear();
		acHead.getChildren().clear();
		acHead.setMaxHeight(0.0);
	}

	@FXML
	private void acMain(KeyEvent event) {
		if (event.getCode() == KeyCode.F11) {
			Stage stage = (Stage) acMain.getScene().getWindow();
			stage.setFullScreen(true);
		}
	}

	@FXML
	public void btnHomeOnClick(ActionEvent event) {
		homeActive();
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			fxmlLoader.load(getClass().getResource("/view/application/home/Home.fxml").openStream());
		} catch (IOException e) {

		}
		AnchorPane root = fxmlLoader.getRoot();
		acContent.getChildren().clear();
		acContent.getChildren().add(root);

		System.out.println(lblUsrName.getText());
		System.out.println(lblUserId.getText());

	}

	@FXML
	private void btnStoreOnClick(ActionEvent event) throws IOException {
		sotreActive();
		// userNameMedia nm = new userNameMedia();
		// FXMLLoader fXMLLoader = new FXMLLoader();
		// fXMLLoader.load(getClass().getResource("/view/application/Stock.fxml").openStream());
		// nm.setId(id);
		// StockController stockController = fXMLLoader.getController();
		// stockController.bpStore.getStylesheets().add("/style/MainStyle.css");
		// stockController.setUserId(usrNameMedia);
		// stockController.btnStockOnAction(event);
		// stockController.settingPermission();
		// AnchorPane acPane = fXMLLoader.getRoot();

		// acContent.getChildren().clear();

		// acContent.getChildren().add(acPane);
	}

	@FXML
	private void btnEmplopyeOnClick(ActionEvent event) throws IOException {
		employeeActive();
		// EmployeController ec = new EmployeController();
		// userNameMedia nm = new userNameMedia();
		// FXMLLoader fXMLLoader = new FXMLLoader();
		// fXMLLoader.load(getClass().getResource("/view/application/Employe.fxml").openStream());
		// nm.setId(id);
		// EmployeController employeController = fXMLLoader.getController();
		// employeController.bpContent.getStylesheets().add("/style/MainStyle.css");
		// employeController.setNameMedia(usrNameMedia);
		// employeController.btnViewEmployeeOnAction(event);

		// AnchorPane acPane = fXMLLoader.getRoot();

		// acContent.getChildren().clear();

		// acContent.getChildren().add(acPane);

	}

	@FXML
	private void btnSettingsOnClick(ActionEvent event) throws IOException {
		settingsActive();
		// inithilize Setting Controller
		// SettingsController settingController = new SettingsController();
		// inithilize UserNameMedia
		// userNameMedia usrMedia = new userNameMedia();
		// Define a loader to inithilize Settings.fxml controller
		// FXMLLoader settingLoader = new FXMLLoader();
		// set the location of Settings.fxml by fxmlloader
		// settingLoader.load(getClass().getResource("/view/application/Settings.fxml").openStream());

		// Send id to userMedia
		// usrMedia.setId(id);
		// take control of settingController elements or node
		// SettingsController settingControl = settingLoader.getController();
		// settingControl.bpSettings.getStylesheets().add("/style/MainStyle.css");

		// settingControl.setUsrMedia(usrMedia);
		// settingControl.miMyASccountOnClick(event);
		// settingControl.settingPermission();

		// AnchorPane acPane = settingLoader.getRoot();
		// acContent clear and make useul for add next node
		// acContent.getChildren().clear();
		// add a node call "acPane" to acContent
		// acContent.getChildren().add(acPane);

	}

	@FXML
	private void btnAboutOnClick(ActionEvent event) {

		// try {
		aboutActive();
		// FXMLLoader fXMLLoader = new FXMLLoader();
		// fXMLLoader.load(getClass().getResource("/view/application/about/AboutMe.fxml").openStream());

		// SellController sellController = fXMLLoader.getController();
		// sellController.acMainSells.getStylesheets().add("/style/MainStyle.css");
		// sellController.tbtnSellOnAction(event);
		// AnchorPane anchorPane = fXMLLoader.getRoot();
		// acContent.getChildren().clear();
		// acContent.getChildren().add(anchorPane);
		// } catch (IOException ex) {
		// Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE,
		// null, ex);
		// }
	}

	@FXML
	private void btnSellOnClick(ActionEvent event) {
		sellActive();
		// SellController controller = new SellController();
		// userNameMedia nm = new userNameMedia();
		// try {

		// FXMLLoader fXMLLoader = new FXMLLoader();
		// fXMLLoader.load(getClass().getResource("/view/application/Sell.fxml").openStream());
		// nm.setId(id);
		// SellController sellController = fXMLLoader.getController();
		// sellController.setNameMedia(usrNameMedia);
		// sellController.acMainSells.getStylesheets().add("/style/MainStyle.css");
		// sellController.tbtnSellOnAction(event);
		// AnchorPane anchorPane = fXMLLoader.getRoot();
		// acContent.getChildren().clear();
		// acContent.getChildren().add(anchorPane);
		// } catch (IOException ex) {
		// Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE,
		// null, ex);
		// }

	}

	@FXML
	private void acMainOnMouseMove(MouseEvent event) {

	}

	private void homeActive() {
		imgHomeBtn.setImage(homeRed);
		imgStoreBtn.setImage(stock);
		imgSellBtn.setImage(sell);
		imgEmployeBtn.setImage(employee);
		imgSettingsBtn.setImage(setting);
		imgAboutBtn.setImage(about);
		btnHome.setStyle(activeStyle);
		btnStore.setStyle(defultStyle);
		btnSell.setStyle(defultStyle);
		btnEmplopye.setStyle(defultStyle);
		btnSettings.setStyle(defultStyle);
		btnAbout.setStyle(defultStyle);
	}

	private void sotreActive() {
		imgHomeBtn.setImage(home);
		imgStoreBtn.setImage(stockRed);
		imgSellBtn.setImage(sell);
		imgEmployeBtn.setImage(employee);
		imgSettingsBtn.setImage(setting);
		imgAboutBtn.setImage(about);
		btnHome.setStyle(defultStyle);
		btnStore.setStyle(activeStyle);
		btnSell.setStyle(defultStyle);
		btnEmplopye.setStyle(defultStyle);
		btnSettings.setStyle(defultStyle);
		btnAbout.setStyle(defultStyle);
	}

	private void sellActive() {
		imgHomeBtn.setImage(home);
		imgStoreBtn.setImage(stock);
		imgSellBtn.setImage(sellRed);
		imgEmployeBtn.setImage(employee);
		imgSettingsBtn.setImage(setting);
		imgAboutBtn.setImage(about);
		btnHome.setStyle(defultStyle);
		btnStore.setStyle(defultStyle);
		btnSell.setStyle(activeStyle);
		btnEmplopye.setStyle(defultStyle);
		btnSettings.setStyle(defultStyle);
		btnAbout.setStyle(defultStyle);
	}

	private void employeeActive() {
		imgHomeBtn.setImage(home);
		imgStoreBtn.setImage(stock);
		imgSellBtn.setImage(sell);
		imgEmployeBtn.setImage(employeeRed);
		imgSettingsBtn.setImage(setting);
		imgAboutBtn.setImage(about);
		btnHome.setStyle(defultStyle);
		btnStore.setStyle(defultStyle);
		btnSell.setStyle(defultStyle);
		btnEmplopye.setStyle(activeStyle);
		btnSettings.setStyle(defultStyle);
		btnAbout.setStyle(defultStyle);
	}

	private void settingsActive() {
		imgHomeBtn.setImage(home);
		imgStoreBtn.setImage(stock);
		imgSellBtn.setImage(sell);
		imgEmployeBtn.setImage(employee);
		imgSettingsBtn.setImage(settingRed);
		imgAboutBtn.setImage(about);
		btnHome.setStyle(defultStyle);
		btnStore.setStyle(defultStyle);
		btnSell.setStyle(defultStyle);
		btnEmplopye.setStyle(defultStyle);
		btnSettings.setStyle(activeStyle);
		btnAbout.setStyle(defultStyle);
	}

	private void aboutActive() {
		imgHomeBtn.setImage(home);
		imgStoreBtn.setImage(stock);
		imgSellBtn.setImage(sell);
		imgEmployeBtn.setImage(employee);
		imgSettingsBtn.setImage(setting);
		imgAboutBtn.setImage(aboutRed);
		btnHome.setStyle(defultStyle);
		btnStore.setStyle(defultStyle);
		btnSell.setStyle(defultStyle);
		btnEmplopye.setStyle(defultStyle);
		btnSettings.setStyle(defultStyle);
		btnAbout.setStyle(activeStyle);
	}

	/*********************************/

	@FXML
	void btnBatal(ActionEvent event) {

	}

	@FXML
	void btnEdit(ActionEvent event) {

	}

	@FXML
	void btnHapus(ActionEvent event) {

	}

	@FXML
	void btnTambah(ActionEvent event) {

	}

	@FXML
	void cariBaju(KeyEvent event) {

	}

	@FXML
	void hlUpdateAccount(ActionEvent event) {

	}

	@FXML
	void klikBaju(MouseEvent event) {

	}

	@FXML
	void mbtnOnClick(ActionEvent event) {

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
}
