import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Porcino } from "../model/Porcino";

@Injectable({
  providedIn: 'root'
})
export class PorcinoService {
    
    private urlBase = "http://localhost:8080/inicio/getPorcinos";
    private urlDelete = "http://localhost:8080/inicio/deletePorcinoById"
    
    constructor (private http : HttpClient){}

    getPorcinos() : Observable<Porcino []> {
        var lista = this.http.get<Porcino[]>(this.urlBase);
        console.log(lista);
        return this.http.get<Porcino[]>(this.urlBase);
    }
    addPorcino( porcino : Porcino) : Observable <Object>{
        return this.http.post(this.urlBase, porcino);
    }
    editPorcino(id:number, porcino : Porcino) : Observable<Object>{
        return this.http.put(`${this.urlBase}/${id}`, porcino);
    }
    deletePorcino(id_porcino : number) : Observable<Object>{
        return this.http.delete(`${this.urlDelete}/${id_porcino}`);
    }
}