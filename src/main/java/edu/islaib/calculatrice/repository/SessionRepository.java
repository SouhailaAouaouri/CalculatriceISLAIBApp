package edu.islaib.calculatrice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.islaib.calculatrice.entites.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer>{
	
	public Session findByEtudiantCin (int cin);
	public Session findByIdsesAndEtudiantCin (int idSes,int cin);
	

}
