package com.projetPharmV2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.projetPharmV2.metier.impl.SendMail;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentMail implements Initializable{
	 @FXML
	    JFXComboBox depCombo;
	    @FXML
	    JFXButton submitBtn;
	    @FXML
	    private JFXTextField shortTxt;
	    @FXML
	    private JFXTextArea longTxt;
	    Task sendingMail;
	    @FXML
	    private AnchorPane anchorPane;
	    @FXML
	    private JFXButton retour;
	    @FXML
	    public void envoyerMail(ActionEvent ae) throws Exception {

	        String sub = "Complaint in" + " " + String.valueOf(depCombo.getValue()) + " - " + shortTxt.getText();
	        String content = longTxt.getText();

	        Task sendingMessage = new Task<Void>() {
	            @Override
	            protected Void call() throws Exception {

	                SendMail mail = new SendMail();


	                mail.sendMail("pharmmail5@gmail.com", "Mo123456", "chaou.redha@gmail.com", sub, content);

	                return null;
	            }
	        };

	        new Thread(sendingMessage).start();

	        longTxt.setText("");
	        shortTxt.setText("");
	        depCombo.setPromptText("Choose a department");

	    }

	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
	        depCombo.getItems().addAll("IT", "Administration", "Software Development", "Personel");

	    }
	    @FXML
	    void retourHome(ActionEvent event) throws IOException {
	    	Parent parent = FXMLLoader.load(getClass().getResource("/view/FXMLDocumentMainAppView.fxml"));
	    	FXMLDocumentControllerUtils.redirection(parent, event, null);
	    }


}
