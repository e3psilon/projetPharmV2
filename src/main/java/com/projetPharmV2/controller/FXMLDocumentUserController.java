package com.projetPharmV2.controller;

import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
@Controller
public class FXMLDocumentUserController {

	 @FXML
	    private TableView<?> teacherTableView;

	    @FXML
	    private TableColumn<?, ?> teacherColumnID;

	    @FXML
	    private TableColumn<?, ?> teacherColumnName;

	    @FXML
	    private TableColumn<?, ?> teacherColumnGPA;

	    @FXML
	    private TableColumn<?, ?> teacherColumnPhone;

	    @FXML
	    private TableColumn<?, ?> teacherEmail;

	    @FXML
	    private ComboBox<?> teacherTableSecChoose;

	    @FXML
	    private Button teacherLoadButton;

	    @FXML
	    private TextField teacherTFAttendance;

	    @FXML
	    private TextField teacherTFAssignment;

	    @FXML
	    private TextField teacherTFPresentation;

	    @FXML
	    private TextField teacherTFClassTest;

	    @FXML
	    private TextField teacherTFMidterm;

	    @FXML
	    private TextField teacherTFFinal;

	    @FXML
	    private Text name;

	    @FXML
	    private Text id;

	    @FXML
	    private Button teacherAddGPAButton;

	    @FXML
	    private Button teacherCancelButton;

	    @FXML
	    void setCourseAboutButtonClick(ActionEvent event) {

	    }

	    @FXML
	    void setCourseCloseButtonClick(ActionEvent event) {

	    }

	    @FXML
	    void setTeacherAddGPAClick(ActionEvent event) {

	    }

	    @FXML
	    void setTeacherCancelClick(ActionEvent event) {

	    }

	    @FXML
	    void setTeacherLoadClick(ActionEvent event) {

	    }

	    @FXML
	    void setTeacherSelectClick(ActionEvent event) {

	    }

}
