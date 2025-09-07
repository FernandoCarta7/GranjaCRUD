import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Porcino } from "../model/Porcino";

@Injectable({
  providedIn: 'root'
})
export class PorcinoService {
    
    private urlBase = "http://localhost:8080/";
    
    constructor (private http : HttpClient){}

    getPorcinos() : Observable<Porcino []> {
        return this.http.get<Porcino[]>(this.urlBase);
    }
    addPorcino( porcino : Porcino) : Observable <Object>{
        return this.http.post(this.urlBase, porcino);
    }
    editPorcino(id:number, porcino : Porcino) : Observable<Object>{
        return this.http.put(`${this.urlBase}/${id}`, porcino);
    }
    deletePorcino(id : number) : Observable<Object>{
        return this.http.delete(`${this.urlBase}/${id}`);
    }
}