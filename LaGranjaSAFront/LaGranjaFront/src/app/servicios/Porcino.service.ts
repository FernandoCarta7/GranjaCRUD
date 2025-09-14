import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Porcino } from "../model/Porcino";

@Injectable({
  providedIn: 'root'
})
export class PorcinoService {
    
    private urlBase = "http://localhost:8080/inicio/getPorcinos";
    private urlGetPorcino = "http://localhost:8080/inicio/getPorcinoByIdPorcino";
    private urlDelete = "http://localhost:8080/inicio/deletePorcinoById"
    //agregarPorcino
    private agregarPorcino = "http://localhost:8080/inicio/agregarPorcino"
    //editarPorcino
    private urlEditarPorcino = "http://localhost:8080/inicio/editarPorcino";
    constructor (private http : HttpClient){}

    getPorcinoById(id_porcino : number){
        console.log('getPorcinoById');
        console.log(id_porcino);
        return this.http.get<Porcino>(`${this.urlGetPorcino}/${id_porcino}`)
    }

    getPorcinos() : Observable<Porcino []> {
        var lista = this.http.get<Porcino[]>(this.urlBase);
        console.log(lista);
        return this.http.get<Porcino[]>(this.urlBase);
    }
    addPorcino( porcino : Porcino) : Observable <Object>{
        console.log(porcino);
        return this.http.post(this.agregarPorcino, porcino);
    }
    editPorcino(id:number, porcino : Porcino) : Observable<Object>{
        return this.http.put(`${this.urlEditarPorcino}/${id}`, porcino);
    }
    deletePorcino(id_porcino : number) : Observable<Object>{
        return this.http.delete(`${this.urlDelete}/${id_porcino}`);
    }
}