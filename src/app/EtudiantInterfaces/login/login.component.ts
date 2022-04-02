import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {EtudiantService} from "../../Service/etudiant.service";
import {FormControl, FormGroup} from "@angular/forms";
import {SecurityLoginService} from "../../Service/security-login.service";
import {Etudiant} from "../../Entities/etudiant";



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
e :Etudiant = new Etudiant();
idSesssion :any;
  session :number;
  ngOnInit(): void {
  }

  constructor(public etudiantService :EtudiantService,
    private router:Router,
              public storag:SecurityLoginService
              ) { }

  goToCalculatice() {
   this.router.navigate(['/calculatrice']);

  }

  login(login: string, pwd:string) {

  this.etudiantService.getLoginEtudiant(login,pwd).subscribe(data=>{
      console.log(data);
    this.e=data as Etudiant;
    if(this.e)
    {


      alert("Welcome Student !")

      this.etudiantService.getIdSessionEtudiantActive(this.e.cin).subscribe(dataRes=>{
        this.idSesssion = dataRes;
        localStorage.setItem("student session",this.idSesssion);
        this.storag.handle(data);


      })
        this.goToCalculatice();


    }},error=>{console.log(error);alert("Your not a Student!"); });
  }

  onsubmit() {

    if(this.etudiantService.formGroup.valid)
    {
      this.login(this.etudiantService.login.value,this.etudiantService.pwd.value);

    }else
    {this.validateAllFormFields(this.etudiantService.formGroup);
    }
  }

  validateAllFormFields(formGroup: FormGroup)
  {Object.keys(formGroup.controls).forEach(field =>
  {const control = formGroup.get(field);
    if (control instanceof FormControl)
    {control.markAsTouched({ onlySelf: true }); }
    else if (control instanceof FormGroup)
    {this.validateAllFormFields(control); }});
  }

}
