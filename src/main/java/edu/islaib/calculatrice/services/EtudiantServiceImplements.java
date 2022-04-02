package edu.islaib.calculatrice.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.islaib.calculatrice.entites.Etudiant;
import edu.islaib.calculatrice.repository.EtudiantRepository;

@Service
public class EtudiantServiceImplements implements EtudiantService{

	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	SessionService sessionService;


	@Override
	public Etudiant addEtudiant (Etudiant a) {
		etudiantRepository.save(a);
		return a;
	}

	@Override
	public Etudiant getEtudiantByCin (int cin) {
		Optional<Etudiant> a=etudiantRepository.findById(cin);
		if (a.isEmpty())
			return null;
		else
		return a.get();
	}

	@Override
	public List<Etudiant> allEtudiants () {
		
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant getEtudiantByLoginandPawd(String login, String pwd) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByLoginAndPwd(login, pwd);
	}


}
	


