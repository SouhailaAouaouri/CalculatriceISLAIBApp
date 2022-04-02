package edu.islaib.calculatrice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.islaib.calculatrice.entites.Session;
import edu.islaib.calculatrice.repository.SessionRepository;

@Service
public class SessionServiceImpl implements SessionService{

	@Autowired
	SessionRepository sessionRepo;
	
	
	@Override
	public Session addSession(Session s) {
		// TODO Auto-generated method stub
		sessionRepo.save(s);
		return s;
	}

	@Override
	public Session getALLSession(int cin) {
		// TODO Auto-generated method stub
		return sessionRepo.findByEtudiantCin(cin);
	}



	@Override
	public Session findByIdsesAndEtudiantCin (int d, int cin) {
		// TODO Auto-generated method stub
		return sessionRepo.findByIdsesAndEtudiantCin(d, cin);
	}

	@Override
	public Session updateSession(Session s) {
		// TODO Auto-generated method stub
		Optional<Session> session =sessionRepo.findById(s.getIdses());
		if(session==null)	
		return null;
		else{
			sessionRepo.save(s);
			return s;
		}
	}

	@Override
	public Session findByEtudiantCin(int cin) {
		// TODO Auto-generated method stub
		
		
		return sessionRepo.findByEtudiantCin(cin);

	}

	@Override
	public int findIdSessionActive(int cin) {
		// TODO Auto-generated method stub
		Session s=sessionRepo.findByEtudiantCin(cin);
		int idSessionActive =s.getIdses();
		
		return idSessionActive;
	}

}
