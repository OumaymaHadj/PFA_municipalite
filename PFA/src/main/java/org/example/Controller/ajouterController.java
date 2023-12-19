package org.example.Controller;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import org.example.Models.Employe;
import org.example.services.EmployeService;
import org.example.services.EmployeServiceImpl;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import oracle.net.ano.Service;
import javafx.scene.control.TextField;

public class ajouterController implements Initializable {
	    PreparedStatement preparedStatement;
	    Connection connection;
	    EmployeServiceImpl EmployeService = new EmployeServiceImpl();
	ObservableList<String>serviceList=FXCollections.observableArrayList("Ressources humaines","Culturel","Informatique","Materiel"
			,"Aménagement territorial et des travaux","Technique","Financier","Affaires sociales");
	 private Employe emp;
       @FXML
       private TextField NomTextField ;
       @FXML
       private TextField PrenomTextField;
       @FXML
       private TextField CINTextField;
       @FXML
       private TextField emailTextField;
       @FXML
       private TextField adresseTextField;
       @FXML
       private TextField telTextField;
	   @FXML
	   private RadioButton FRadioButton;
	   @FXML
	   private RadioButton MRadioButton;
	   @FXML
	   private DatePicker NaissDatePicker;
	   @FXML
	   private ChoiceBox ServiceChoiceBox;
	   @FXML
	   private ToggleGroup tgGenre;
	   @FXML
	    Label lblStatus1;
	   @FXML
	    Label lblStatus2;
	   @FXML
	    Label lblStatus3;
	   @FXML
	    Label lblStatus4;
	   @FXML
	    Label lblStatus5;
	   @FXML
	    Label lblStatus6;
	   @FXML
	    Label lblStatus7;
	   @FXML
	    Label lblStatus8;
	    @Override
	    public void initialize(URL url, ResourceBundle rb)
	    { 
	    	
	    	ServiceChoiceBox.setItems(serviceList);
	    }
	    
	    public String getSexeE() {
	    	String gen="";
	    	if (MRadioButton.isSelected()) {
	    		gen="M";
	    	}
	    	else {
	    		gen="F";
	    	}
	    	return gen;
	    }
	    
	    private boolean cinCORRECT() {
	         boolean test = false;
	        String cin = CINTextField.getText();
	           test= EmployeService.find(new Employe(cin));
	         return test;
	    }
	
	    
	    @FXML
	    private void HandleEvents(MouseEvent event) {
	        //check if not empty
	    	 String status ="error";
	    	 if (NomTextField.getText().isEmpty()||PrenomTextField.getText().isEmpty()||CINTextField.getText().isEmpty()
	    			 ||!cinCORRECT()==false ||(!CINTextField.getText().matches("[+-]?\\d*(\\.\\d+)?")) || (!(CINTextField.getText().length()==8))
	    			 || emailTextField.getText().isEmpty() || !emailTextField.getText().matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+" )
	    			 ||telTextField.getText().isEmpty()  || (!telTextField.getText().matches("[+-]?\\d*(\\.\\d+)?")) || (!(telTextField.getText().length()==8))
	    			 || adresseTextField.getText().isEmpty() ||  NaissDatePicker.getValue()==null|| ServiceChoiceBox.getValue()==null
	    			 ) {
	    		 Alert alert = new Alert(AlertType.WARNING);
			    	alert.setHeaderText("Problème survenu veuillez réessayer ultérieurement ");
		        	alert.showAndWait();
	    		 
	    		 if (NomTextField.getText().isEmpty() ) {
	            lblStatus1.setTextFill(Color.TOMATO);
	            lblStatus1.setText("saisir le nom");
	            }
	        else
	        {  lblStatus1.setText("");
	        	status ="Success";
	        }
	        if (PrenomTextField.getText().isEmpty() ) {
	            lblStatus2.setTextFill(Color.TOMATO);
	            lblStatus2.setText("saisir le prenom");
	            }
	        else
	        {  lblStatus2.setText("");
	        	status ="Success";
	        }
	        if (CINTextField.getText().isEmpty() ) {
	            lblStatus3.setTextFill(Color.TOMATO);
	            lblStatus3.setText("saisir le CIN");
	            }
	      
	        else if   (!cinCORRECT()==false) {
	        	lblStatus3.setTextFill(Color.TOMATO);
	            lblStatus3.setText("CIN existe déja");
	           
	        }
	        else if ((!CINTextField.getText().matches("[+-]?\\d*(\\.\\d+)?")) || (!(CINTextField.getText().length()==8))){
	        	 lblStatus3.setTextFill(Color.TOMATO);
		         lblStatus3.setText("saisir correct CIN");
	        }
	        else
	        {  lblStatus3.setText(" ");
	        	status ="Success";
	        }
	        if (emailTextField.getText().isEmpty() ) {
	            lblStatus4.setTextFill(Color.TOMATO);
	            lblStatus4.setText("saisir l'email ");}
	        else if (!emailTextField.getText().matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+" )) {
	        	lblStatus4.setTextFill(Color.TOMATO);
	            lblStatus4.setText("Enter correct email");
	        }
	        else
	        {  lblStatus4.setText("");
	        	status ="Success";
	        }
	        if (telTextField.getText().isEmpty()  ) {
	            lblStatus5.setTextFill(Color.TOMATO);
	            lblStatus5.setText("saisir Tel");}
	        else if ((!telTextField.getText().matches("[+-]?\\d*(\\.\\d+)?")) || (!(telTextField.getText().length()==8))){
	        	 lblStatus5.setTextFill(Color.TOMATO);
		         lblStatus5.setText("saisir correct Tel");
	        }
	        else
	        {  lblStatus5.setText("");
	        	status ="Success";
	        }
	        if (adresseTextField.getText().isEmpty()  ) {
	            lblStatus8.setTextFill(Color.TOMATO);
	            lblStatus8.setText("saisir l'adresse");}
	        else
	        {  lblStatus8.setText("");
	        	status ="Success";
	        }
	        if (NaissDatePicker.getValue()==null ) {
	            lblStatus6.setTextFill(Color.TOMATO);
	            lblStatus6.setText("saisir le date de naissance");}
	        else
	        {  lblStatus6.setText(" ");
	        	status ="Success";
	        }
	        if (ServiceChoiceBox.getValue()==null) {
	            lblStatus7.setTextFill(Color.TOMATO);
	            lblStatus7.setText("saisir le nom de service ");}
	        else
	        {  lblStatus7.setText("");
	        	status ="Success";
	        }
	     
	    	 }
	    	 else {
	        	emp= new Employe(CINTextField.getText(),NomTextField.getText(),PrenomTextField.getText(),emailTextField.getText(),getSexeE(),NaissDatePicker.getValue().toString(),adresseTextField.getText(), ServiceChoiceBox.getValue().toString(),telTextField.getText());
	        	EmployeService.add(emp);
	        	Alert alert = new Alert(AlertType.CONFIRMATION);
		    	alert.setHeaderText("Ajout réussie ");
	        	alert.showAndWait();}
	        	
        	 
	       

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
	    
	    public void clear() {
	   	 adresseTextField.clear();
	   	 CINTextField.clear();
	   	 emailTextField.clear();
	   	 NomTextField.clear();
	   	 PrenomTextField.clear();
	   	 telTextField.clear();
	   	 NaissDatePicker.getEditor().clear();
	   	 ServiceChoiceBox.setValue(null);
	   	 
	    }

}
