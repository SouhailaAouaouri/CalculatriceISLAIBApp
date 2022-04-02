package edu.islaib.calculatrice.services;

import java.util.List;

import edu.islaib.calculatrice.entites.Etudiant;

public interface EtudiantService {

	//public Etudiant findByLoginAndPassword(String login,String password);
	public Etudiant addEtudiant (Etudiant a);
	public Etudiant getEtudiantByCin (int cin);
	public List<Etudiant> allEtudiants ();
	public Etudiant getEtudiantByLoginandPawd (String login,String pwd);
//	public void LogOutEtudiant (int idSes,int cin);



}
