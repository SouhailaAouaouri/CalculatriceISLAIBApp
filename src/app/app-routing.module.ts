import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CalculatriseComponent} from "./Calculatrice/calculatrise/calculatrise.component";
import {LoginComponent} from "./EtudiantInterfaces/login/login.component";

const routes: Routes = [
  {path:'calculatrice',component: CalculatriseComponent},
  {path:'login',component: LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
