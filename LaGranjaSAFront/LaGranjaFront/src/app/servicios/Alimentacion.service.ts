import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Alimentacion } from "../model/Alimentacion";

@Injectable({
  providedIn: 'root'
})
export class AlimentacionService {
    
    private urlBase = "http://localhost:8080/";
    
    constructor (private http : HttpClient){}

    getAlimentacion() : Observable<Alimentacion []> {
        return this.http.get<Alimentacion[]>(this.urlBase);
    }
    addAlimentacion( alimentacion : Alimentacion) : Observable <Object>{
        return this.http.post(this.urlBase, alimentacion);
    }
    editAlimentacion(id:number, alimentacion : Alimentacion) : Observable<Object>{
        return this.http.put(`${this.urlBase}/${id}`, alimentacion);
    }
    deleteAlimentacion(id : number) : Observable<Object>{
        return this.http.delete(`${this.urlBase}/${id}`);
    }
}