import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CalculatriseService {

  urlpath: string;
  constructor(private http: HttpClient) {
    this.urlpath = 'http://localhost:8080/calcul';
  }

  addFunction (a:number, b:number,cin :number,idSession :number){
    return this.http.get(this.urlpath+'/add/'+ a+ '/'+ b+ '/'+cin+'/'+idSession);
  }
  multiplicationFunction (a:number, b:number,cin :number,idSession :number){
    return this.http.get(this.urlpath+'/multiplication/'+  a+ '/'+ b+ '/'+cin+'/'+idSession);
  }
  sustractionFunction (a:number, b:number,cin :number,idSession :number){
    return this.http.get(this.urlpath+'/sustraction/'+  a+ '/'+ b+ '/'+cin+'/'+idSession);
  }
  divsionFunction (a:number, b:number,cin :number,idSession :number){
    return this.http.get(this.urlpath+'/division/'+  a+ '/'+ b+ '/'+cin+'/'+idSession);
  }


}
