import {Operation} from "./operation";
import {Etudiant} from "./etudiant";

export class Session {
  idses:number;
  datelogin :Date;
  dateLogOut :Date;
  listOperation :Array<Operation>;
  etudiant:Etudiant;
}
