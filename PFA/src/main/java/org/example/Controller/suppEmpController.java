package org.example.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.example.Models.Employe;
import org.example.services.EmployeService;
import org.example.services.EmployeServiceImpl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class suppEmpController implements Initializable{  
	 EmployeServiceImpl EmployeService = new EmployeServiceImpl();
	Employe emp;
	@FXML
	TextField LibCinEmp;
	
	@FXML
	public void supprimerEmploye() {
		String cin=LibCinEmp.getText();
		emp= new Employe(cin);
		if (EmployeService.find(emp)) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.showAndWait();
			EmployeService.supp(emp);
			}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText(" aucun employé n'a ce numéro de CIN ");
			alert.showAndWait();
			EmployeService.supp(emp);
		}
	}
	public void clear() {
		 LibCinEmp.clear();
	}
	  @FXML
	    public void HandleEvents5(MouseEvent event) {
		   try {
           //add you loading or delays - ;-)
           Node node = (Node) event.getSource();
           Stage stage = (Stage) node.getScene().getWindow();
           //stage.setMaximized(true);
           stage.close();

           Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/org/example/views/gestionEmp.fxml")));
           stage.setScene(scene);
           stage.show();

       } catch (IOException ex) {
           System.err.println(ex.getMessage());}
       }
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
