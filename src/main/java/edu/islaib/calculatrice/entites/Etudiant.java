package edu.islaib.calculatrice.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Etudiant implements Serializable {

	@Id
	private int cin;
	private String nom;
	private String prenom;
	private String login;
	private String pwd;
	@JsonIgnore
	@OneToMany(mappedBy = "etudiant")
	private List<Session> listSessions;
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public List<Session> getListSessions() {
		return listSessions;
	}
	public void setListSessions(List<Session> listSessions) {
		this.listSessions = listSessions;
	}

	
}
