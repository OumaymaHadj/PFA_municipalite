package org.example.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.Models.Service;
import org.example.utils.connexionBd;



public class ServiceDAO {
	  Statement con = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    public ServiceDAO ()  {
	        try{
	            con= connexionBd.getInstance();
	            System.out.println("instance created");} catch (Exception e) {
	            e.printStackTrace();}
	        }
	        public boolean find( Service s) {

	            boolean test= false;
	            ResultSet r;
	            try {

	                resultSet =con.executeQuery("select * from service where NOMS = '"+s.getNOMS()
	                        + "' and MDP = '"+s.getMDP()+"'");
	                if (resultSet.next()) { test=true;}
	            } catch (SQLException throwables) {
	                System.out.println("prob ici");
	                throwables.printStackTrace();
	            }
	            return test;
	        }
	        

	    }


