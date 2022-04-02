package edu.islaib.calculatrice.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.islaib.calculatrice.entites.Operation;
import edu.islaib.calculatrice.entites.Session;
import edu.islaib.calculatrice.services.CalculatriceService;
import edu.islaib.calculatrice.services.EtudiantService;
import edu.islaib.calculatrice.services.OperationService;
import edu.islaib.calculatrice.services.SessionService;


@RestController
@RequestMapping("/calcul")//localhost:8080/calcul
public class CalculatriseController {
	
	@Autowired
	EtudiantService etudiantserv;
	
	@Autowired
	CalculatriceService calculatriceService;
	
	@Autowired
	OperationService operationserv;
	
	@Autowired
	SessionService sessionServe;
	
	
	@GetMapping("/add/{a}/{b}/{cin}/{idSession}")
	public double addFunction (@PathVariable double a,@PathVariable double b, @PathVariable int cin, @PathVariable int idSession)
	{

		// Etape 1&2:  recupprer la session actuelle ml localstorg angular
		Session ss=sessionServe.findByIdsesAndEtudiantCin(idSession,cin);
		// Etape 3: recuperer list des operation de cette session ouvert
		List<Operation> listOp= operationserv.allOperationOfSeesion(cin);
		// Etape 4: fait la calcul
		double res=calculatriceService.addFunc(a, b);
		//new operation va creer pour sauvegarder
		Operation opr=new Operation();
		opr.setA(a);
		opr.setB(b);
		opr.setOperateur(" + ");
		opr.setResult(res);
		opr.setSession(ss);
		// Etape 5: save l'operation dans la table operation avec idSession
		operationserv.saveOperation(opr);
		// Etapa 6:Ajouter l'operation effectuer à la liste des operation d'etudiant 
		listOp.add(opr);
		// Etape 7 : mise a jour list des operation de session d'etudiant actuelle
		ss.setListOperation(listOp);
		 
		return res;
	}
	
	@GetMapping("/multiplication/{a}/{b}/{cin}/{idSession}")
	public double multiplicationFunction (@PathVariable double a,@PathVariable double b, @PathVariable int cin, @PathVariable int idSession)
	{

		//E2&1
		Session ss=sessionServe.findByIdsesAndEtudiantCin(idSession,cin);
		//E3
		List<Operation> listOp= operationserv.allOperationOfSeesion(idSession);
		//E4
		double res=calculatriceService.multiplicationFunc(a, b);
		Operation opr=new Operation();
		opr.setA(a);
		opr.setB(b);
		opr.setOperateur(" * ");
		opr.setResult(res);
		opr.setSession(ss);
		//E5
		operationserv.saveOperation(opr);
		//E6
		listOp.add(opr);
		//E7
		ss.setListOperation(listOp);

		return res;
	}
	
	@GetMapping("sustraction/{a}/{b}/{cin}/{idSession}")
	public double sustractionFunction (@PathVariable double a,@PathVariable double b, @PathVariable int cin, @PathVariable int idSession)
	{


		//E2&1
		Session ss=sessionServe.findByIdsesAndEtudiantCin(idSession,cin);
		//E3
		List<Operation> listOp= operationserv.allOperationOfSeesion(idSession);
		//E4
		double res=calculatriceService.sustractionFunc(a, b);
		Operation opr=new Operation();
		opr.setA(a);
		opr.setB(b);
		opr.setOperateur(" - ");
		opr.setResult(res);
		opr.setSession(ss);
		//E5
		operationserv.saveOperation(opr);
		//E6
		listOp.add(opr);
		//E7
		ss.setListOperation(listOp);

		return res;		
	}
	
	@GetMapping("/division/{a}/{b}/{cin}/{idSession}")
	public double divsionFunction (@PathVariable double a,@PathVariable double b, @PathVariable int cin, @PathVariable int idSession)
	{

		//E2
		Session ss=sessionServe.findByIdsesAndEtudiantCin(idSession,cin);
		//E3
		List<Operation> listOp= operationserv.allOperationOfSeesion(idSession);
		//E4
		double res= calculatriceService.divisionFunc(a, b);
		Operation opr=new Operation();
		opr.setA(a);
		opr.setB(b);
		opr.setOperateur(" / ");
		opr.setResult(res);
		opr.setSession(ss);
		//E5
		operationserv.saveOperation(opr);
		//E6
		listOp.add(opr);
		//E7
		ss.setListOperation(listOp);

		return res;		
	}

}
