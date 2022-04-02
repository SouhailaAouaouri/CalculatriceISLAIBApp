package edu.islaib.calculatrice.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.islaib.calculatrice.entites.Operation;
import edu.islaib.calculatrice.repository.OperationRepository;

@Service
public class OperationServiceImpl implements OperationService{

	@Autowired
	OperationRepository operationRepo;
	
	@Override
	public List<Operation> allOperationOfSeesion(int d) {
		// TODO Auto-generated method stub
		return operationRepo.findBySessionIdses(d);
	}

	@Override
	public Operation saveOperation(Operation op) {
		// TODO Auto-generated method stub
		operationRepo.save(op);
		return op;
	}
	

}
