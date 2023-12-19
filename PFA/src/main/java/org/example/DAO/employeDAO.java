package org.example.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import org.example.Models.Employe;


import java.util.LinkedList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.example.utils.connexionBd;

import com.sun.jdi.connect.spi.Connection;

public class employeDAO {
	  Statement con = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    public employeDAO ()  {
	        try{
	            con= connexionBd.getInstance();
	            System.out.println("instance created");} catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	    
	    public boolean find( Employe emp) {

	        boolean test= false;


	       
	       
	        try {
	        	
	            resultSet =con.executeQuery("select * from employe where cinE = '"+emp.getCIN()+"'");
	        
	            if (resultSet.next()) { test=true;}


	        } catch (SQLException throwables) {
	            System.out.println("prob ici");
	            throwables.printStackTrace();
	        }
	        return test;
	    }
	    public void add(Employe emp) {

	        try {
	            String st = "INSERT INTO employe ( cinE , nomE,prenomE , emailE, sexeE,dateNaisE,adresseE,nomS,telE) VALUES  (" + "'"+emp.getCIN()+ "'"+"," + "'"+emp.getNom() + "'"+ "," + "'" +emp.getPrenom() + "'" + "," + "'"+ emp.getEmail() + "'" + "," + "'"+ emp.getSexe() + "'"+"," + "'"+ emp.getDateNaiss()+ "'"+ "," + "'"+ emp.getAdresse()+ "'" + "," + "'"+emp.getService()+ "'"+","+ "'"+ emp.getNumTlf() + "'"+")";
	            int i =con.executeUpdate(st);
	            




	        } catch (SQLException ex) {
	            System.out.println("probeme içi");
	            System.out.println(ex.getMessage());


	        }}
	        public void supp(Employe emp) {

		        try {
		            String st = "DELETE FROM employe WHERE CINE="+emp.getCIN();
		            int i =con.executeUpdate(st);
		           

		        } catch (SQLException ex) {
		            System.out.println("probeme içi");
		            System.out.println(ex.getMessage());
		           


		        }
	    } 
	        
	       	        

}
	    
