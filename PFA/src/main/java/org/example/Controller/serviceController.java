package org.example.Controller;

import java.awt.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.example.Models.Service;
import org.example.services.SerServiceImpl;
import org.example.utils.connexionBd;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class serviceController implements Initializable {
	  

	 @FXML
     private TextField txtUsername ;
     @FXML
     private TextField txtPassword;
    

	

	    SerServiceImpl SerService = new SerServiceImpl();
	   
	    
	    @FXML
	    public void HandleEvents(MouseEvent event) {

	 
	            if (logIn().equals("Success")) {
	            	if (Inter().equals("Ressources humaines")) {
	                try {
	                    //add you loading or delays - ;-)
	                    Node node = (Node) event.getSource();
	                    Stage stage = (Stage) node.getScene().getWindow();
	                    //stage.setMaximized(true);
	                    stage.close();

	                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/org/example/views/RessourcesHumaines.fxml")));
	                    stage.setScene(scene);
	                    stage.show();

	                } catch (IOException ex) {
	                    System.err.println(ex.getMessage());
	                }

	            }}
	        }
	    
 
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
			 
		}
	    private String logIn() {
	        String status = "Success";
	        boolean test = false;
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Erreur");
	        String username = txtUsername.getText();
	        String password = txtPassword.getText();
	        if(username.isEmpty() || password.isEmpty()) {
	        	 status = "Error";
	        	alert.setHeaderText("les champs sont vides ");
	        	alert.showAndWait();
	            
	        } else {
	           test= SerService.find(new Service(username,password));
	           if (test ==false)
	               {
	        	
		        	alert.setHeaderText("Connexion échouée ");
		        	alert.setContentText("veuillez vérifier Nom Service / Mot de passe ");
		        	alert.showAndWait();
	        	 
	                    status = "Error";
	                } else {
	               status= "Success";
	              
	        	 
	                }

	        }

	        return status;
	    }
	    private String Inter() {
	    	String inter="Culturel";
	        String username = txtUsername.getText();
	       
	          if (("Culturel").equals(username)) {
	        	  
	        	  inter="Culturel";
	        }
	          else if (("Ressources humaines").equals(username)) {
	        	  inter="Ressources humaines";
	          }

	        return inter ;
	    }
 public void clear() {
	 txtPassword.clear();
	 txtUsername.clear();
 }
 
	    
	    
	    
}

