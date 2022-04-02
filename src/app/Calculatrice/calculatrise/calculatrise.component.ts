import { Component, OnInit } from '@angular/core';
import {CalculatriseService} from "../../Service/calculatrise.service";
import {Router} from "@angular/router";
import {FormControl} from "@angular/forms";
import {SecurityLoginService} from "../../Service/security-login.service";
import {EtudiantService} from "../../Service/etudiant.service";


@Component({
  selector: 'app-calculatrise',
  templateUrl: './calculatrise.component.html',
  styleUrls: ['./calculatrise.component.css']
})
export class CalculatriseComponent implements OnInit {
 /*  user name  */
  userName =this.storag.getNameUser();
  userLastName =this.storag.getLastNameUser();
  /* variable des fct  */
  cinSt=Number(this.storag.getCinUser());
  //idSession=this.storag.getSessionUser();
  sesion=parseInt(localStorage.getItem("student session"));

  constructor(public calculService :CalculatriseService,
              private router:Router,
              public storag:SecurityLoginService,
              public  etudiantService : EtudiantService) { }
  input:string = '';






result :any;
 a=new FormControl("");
  b= new FormControl("");

  ngOnInit(): void {
    console.log(this.storag.getLastNameUser());
    console.log(this.storag.getNameUser());
    console.log((this.storag.getSessionUser()));
    console.log(parseInt(localStorage.getItem("student session")));
    console.log(this.storag.getCinUser());

  }


//fonction principal pour le calculatrice

  addFunction (a:number, b:number) {

 this.calculService.addFunction(a,b,this.cinSt,this.sesion).subscribe(data =>{
   this.result=data;
   console.log(data);
 });
  }
  multiplicationFunction (a:number, b:number) {

this.calculService.multiplicationFunction(a,b,this.cinSt,this.sesion).subscribe(data =>{
  this.result=data;
  console.log(data);
});
  }
  sustractionFunction (a:number, b:number) {

  this.calculService.sustractionFunction(a,b,this.cinSt,this.sesion).subscribe(data =>{
  this.result=data;
  console.log(data);
});
  }
  divsionFunction (a:number, b:number) {

   this.calculService.divsionFunction(a,b,this.cinSt,this.sesion).subscribe(data =>{
     this.result=data;
     console.log(data);
   });
  }

  logOut(){

    this.etudiantService.getLogOutEtudiant(this.cinSt,this.sesion).subscribe(data=>{
      console.log(data);
    },error => console.log(error));
    this.storag.removeUserStorage();
    this.router.navigate(['/login']);
  }

  test() {
    console.log(this.a.value);
    console.log(this.b.value);
    console.log(this.sesion);
    console.log(this.cinSt);
  }
}
