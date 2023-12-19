package org.example.Models;
import java.util.Date;
public class Employe {

	private String CIN;
	private String Nom;
	private String prenom;
	private String email;
	private String sexe;
	private String dateNaiss;
	private String adresse;
	private String service;
	private String numTlf;
	
	
	public Employe(String cIN) {
		super();
		CIN = cIN;
	}

	public Employe(String CIN, String Nom, String prenom, String email, String sexe, String dateNaiss, String adresse,
			String service ,String numTlf) {
		super();
		this.CIN = CIN;
		this.Nom = Nom;
		this.prenom = prenom;
		this.email = email;
		this.sexe = sexe;
		this.dateNaiss = dateNaiss;
		this.adresse = adresse;
		this.service = service;
		this.numTlf=numTlf;
	}
	
	public String getNumTlf() {
		return numTlf;
	}

	public void setNumTlf(String numTlf) {
		this.numTlf = numTlf;
	}

	public Employe() {
		super();
	}
	

	public String getCIN() {
		return CIN;
	}
	public void setCIN(String CIN) {
		this.CIN = CIN;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String Nom) {
		this.Nom = Nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Employe [CIN=" + CIN + ", Nom=" + Nom + ", prenom=" + prenom + ", email=" + email + ", sexe=" + sexe
				+ ", dateNaiss=" + dateNaiss + ", adresse=" + adresse + ", service=" + service + "]";
	}
	
	
}
