package edu.islaib.calculatrice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.islaib.calculatrice.entites.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{
	
	public Etudiant findByLoginAndPwd(String login,String pwd);

}
