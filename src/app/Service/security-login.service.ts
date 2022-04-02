import { Injectable } from '@angular/core';
const User_Name = 'student name';
const User_LastName ='Student LastName;'
const User_CIN = 'student cin';
const User_SessionId = 'student session';


@Injectable({
  providedIn: 'root'
})
export class SecurityLoginService {

  constructor() { }

  public savedata(data: any): void {
    localStorage.setItem(User_Name, data.nom);
    localStorage.setItem(User_LastName, data.prenom);
    localStorage.setItem(User_CIN, data.cin);
  }


  /*  get */
  getNameUser() {
    return localStorage.getItem(User_Name);
  }
  getLastNameUser() {
    return localStorage.getItem(User_LastName);
  }
  getCinUser() {
    return localStorage.getItem(User_CIN);
  }
  getSessionUser() {
    return localStorage.getItem(User_SessionId);
  }
  /*  romove */
  removeUserStorage() {
    localStorage.removeItem(User_CIN);
    localStorage.removeItem(User_SessionId);
    localStorage.removeItem(User_Name)
    localStorage.removeItem(User_LastName);
    window.localStorage.clear();

  }
  handle(data) {
    this.savedata(data);
  }

}
