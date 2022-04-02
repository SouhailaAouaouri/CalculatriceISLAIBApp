package edu.islaib.calculatrice.controllers;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.islaib.calculatrice.entites.Etudiant;
import edu.islaib.calculatrice.entites.Session;
import edu.islaib.calculatrice.services.EtudiantService;
import edu.islaib.calculatrice.services.SessionService;

@RestController
@RequestMapping("/etudiant")//localhost:8080/etudiant
public class EtudiantController {
	
	@Autowired
	EtudiantService etudService;
	@Autowired
	SessionService sessionService;
	
	@PostMapping("/addEtudiant")
	public Etudiant addEtudiant (@RequestBody Etudiant a) {
		return etudService.addEtudiant(a);
		
	}
	
	@GetMapping("/By/{cin}")
	public Etudiant getEtudiant (@PathVariable int cin) {
		return etudService.getEtudiantByCin(cin);
		
	}
	
	@GetMapping("/login/{login}/{pwd}")
	public ResponseEntity<Etudiant> loginEtudiant (@PathVariable String login,@PathVariable String pwd ) {
		Etudiant e= etudService.getEtudiantByLoginandPawd(login, pwd);
		Session s =new Session();
		if (e ==null)
		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			//recupere et convertir date 
			Date d=new Date();
			LocalDateTime ldt=LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
			Date dOut=Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
			
			s.setDatelogin(dOut);
			s.setDateLogOut(null);
			s.setEtudiant(e);
			s.setListOperation(null);
		 sessionService.addSession(s);
			return new  ResponseEntity<Etudiant>(e,HttpStatus.OK);

		}
	}
	
	@GetMapping("/logOut/{cin}/{idSession}")
	public ResponseEntity<Session> logOutEtudiant 	(@PathVariable int cin,@PathVariable int idSession)
	{

		Session s= sessionService.findByIdsesAndEtudiantCin(idSession, cin);
		if (s.getDateLogOut() ==null)
			{
			
			//recupere et convertir date 
			Date d=new Date();
			LocalDateTime ldt=LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
			Date dOut=Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
			
			s.setDateLogOut(dOut);
			sessionService.updateSession(s);
			return new ResponseEntity<Session>(s,HttpStatus.OK);
			}
		else {
		 
			return new  ResponseEntity<Session>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/IdSessionActive/{cin}")
  public int 	getIdSessionEtudiantActive (@PathVariable int  cin)
  {
	  
	  Session s=sessionService.findByEtudiantCin(cin);
	  Date dateLogIN = s.getDatelogin();
	  Date dateLogOut =s.getDateLogOut();
	  
	  if((dateLogIN != null )&& (dateLogOut==null))
	  {
		  int idSession=s.getIdses();
		  return idSession;

	  }else return 0;
	

	  
  }

}
