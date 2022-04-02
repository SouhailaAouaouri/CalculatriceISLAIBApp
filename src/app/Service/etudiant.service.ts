import { Injectable } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class EtudiantService {
  urlpath: string;
  constructor(private fb: FormBuilder,
              private http: HttpClient) {
    this.urlpath = 'http://localhost:8080/etudiant';
  }

  get login(){
    return this.formGroup.get('Username');
  }

  get pwd(){
    return this.formGroup.get('Pwd');
  }

  formGroup = this.fb.group({
    Username: ['', Validators.required],
    Pwd: ['', Validators.required ]
  });

getLoginEtudiant (login:string, pwd:string){
  return this.http.get(this.urlpath+'/login/'+ login+ '/'+ pwd);
}

getLogOutEtudiant (cin : number, idSession :number )
{
  return this.http.get(this.urlpath+'/logOut/'+ cin +'/'+ idSession);
}

  getIdSessionEtudiantActive (cin : number)
  {
    return this.http.get(this.urlpath+'/IdSessionActive/'+ cin );
  }

}
