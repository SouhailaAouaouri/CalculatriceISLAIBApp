package edu.islaib.calculatrice.entites;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Session implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idses;
	private Date datelogin;
	private Date dateLogOut;
	@JsonIgnore
	@OneToMany(mappedBy = "session")
	private List<Operation> listOperation;
	@JsonIgnore
	@ManyToOne
	private Etudiant etudiant;

	

	public int getIdses() {
		return idses;
	}

	public void setIdses(int idses) {
		this.idses = idses;
	}

	public Date getDatelogin() {
		return datelogin;
	}

	public void setDatelogin(Date datelogin) {
		this.datelogin = datelogin;
	}

	public Date getDateLogOut() {
		return dateLogOut;
	}

	public void setDateLogOut(Date dateLogOut) {
		this.dateLogOut = dateLogOut;
	}

	public List<Operation> getListOperation() {
		return listOperation;
	}

	public void setListOperation(List<Operation> listOperation) {
		this.listOperation = listOperation;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

}
