package com.projetPharmV2;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
@EnableAutoConfiguration
public class AppPharmApplication extends Application implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static ConfigurableApplicationContext applicationContext;
	// public static Parent root;
	// public static Scene scene;

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentLogin.fxml"));
		stage.setTitle("Connexion");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {

		applicationContext = SpringApplication.run(AppPharmApplication.class);
		Application.launch(args);

	}

}
