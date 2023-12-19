
package org.example.services;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import org.example.DAO.employeDAO;
import org.example.Models.Employe;

import org.example.utils.connexionBd;
public class EmployeServiceImpl implements EmployeService {
	  Statement con = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    employeDAO employeDAO = new employeDAO();
	    public EmployeServiceImpl()  {
	        try{
	        con= connexionBd.getInstance();
	        System.out.println("instance created");} catch (Exception e) {
	            e.printStackTrace();
	        }

	    }

        public boolean find (Employe emp) {
        	return(employeDAO.find(emp));
        }
	    public void add(Employe emp) {
	        employeDAO.add(emp);
	    }
	    public void supp(Employe emp) {
	    	employeDAO.supp(emp);
	    }
	 
}
