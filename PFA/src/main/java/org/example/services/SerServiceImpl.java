package org.example.services;

import org.example.DAO.ServiceDAO;
import org.example.Models.Service;

public class SerServiceImpl implements SerService{
	  ServiceDAO ServiceDAO= new ServiceDAO();
	    public boolean find( Service s) {
	        return(ServiceDAO.find(s));
	    }}
