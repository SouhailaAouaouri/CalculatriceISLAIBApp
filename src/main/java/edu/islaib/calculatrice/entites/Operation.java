package edu.islaib.calculatrice.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Operation implements Serializable{
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double a;
	private double b;
	private String operateur;
	private double result;
    @JsonIgnore
	@ManyToOne
	private Session session;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	
	

}
