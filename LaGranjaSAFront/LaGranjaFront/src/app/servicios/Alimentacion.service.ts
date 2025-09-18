import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Alimentacion } from "../model/Alimentacion";
import { Raza } from "../model/Raza";

@Injectable({
  providedIn: 'root'
})
export class AlimentacionService {
    
    private urlBase = "http://localhost:8080/";
    private urlGetByRaza = "http://localhost:8080/inicio/getAlimentacionByIdRaza"
    private urlGet = "http://localhost:8080/inicio/getAlimentacion"
    
    constructor (private http : HttpClient){}

    getAlimentacion() : Observable<Alimentacion []> {
        return this.http.get<Alimentacion[]>(this.urlGet);
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

    getAlimentacionByRaza( id_raza : number ): Observable<Alimentacion []>{
        return this.http.get<Alimentacion[]>(`${this.urlGetByRaza}/${id_raza}`)
    }

}