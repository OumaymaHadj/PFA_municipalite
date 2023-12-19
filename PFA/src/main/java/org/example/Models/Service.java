package org.example.Models;

public class Service {
  
	  private   String NOMS;

	   private String MDP;

	public Service(String nOMS, String mDP) {
		super();
		NOMS = nOMS;
		MDP = mDP;
	}

	public String getNOMS() {
		return NOMS;
	}

	public void setNOMS(String nOMS) {
		NOMS = nOMS;
	}

	public String getMDP() {
		return MDP;
	}

	public void setMDP(String mDP) {
		MDP = mDP;
	}
	
	  
}
