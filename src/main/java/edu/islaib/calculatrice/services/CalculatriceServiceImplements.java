package edu.islaib.calculatrice.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatriceServiceImplements implements CalculatriceService{

	@Override
	public double addFunc(double a, double b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public double multiplicationFunc(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double sustractionFunc(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double divisionFunc(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}
