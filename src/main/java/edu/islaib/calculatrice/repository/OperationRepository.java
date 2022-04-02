package edu.islaib.calculatrice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.islaib.calculatrice.entites.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer>{
	
	public List<Operation> findBySessionIdses (int idSes);

}
