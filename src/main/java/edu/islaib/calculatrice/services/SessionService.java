package edu.islaib.calculatrice.services;



import edu.islaib.calculatrice.entites.Session;

public interface SessionService {

	public Session addSession(Session s);
	public Session updateSession(Session s);
	public Session getALLSession(int cin);
	public Session findByIdsesAndEtudiantCin (int idSession,int cin);
	public Session findByEtudiantCin (int cin);
	public int findIdSessionActive (int cin);


}
