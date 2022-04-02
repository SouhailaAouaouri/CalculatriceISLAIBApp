package edu.islaib.calculatrice.services;


import java.util.List;

import edu.islaib.calculatrice.entites.Operation;

public interface OperationService {
	
	public List<Operation> allOperationOfSeesion (int idSes);
	public Operation saveOperation (Operation op);

}
