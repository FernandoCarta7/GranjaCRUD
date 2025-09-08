import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Cliente } from "../model/Cliente";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
    
    private urlBase = "http://localhost:8080/inicio/getClientes";
    
    constructor (private http : HttpClient){}

    getClientes() : Observable<Cliente []> {
        return this.http.get<Cliente[]>(this.urlBase);
    }
    addCliente( cliente : Cliente) : Observable <Object>{
        return this.http.post(this.urlBase, cliente);
    }
    editCliente(id:number, cliente : Cliente) : Observable<Object>{
        return this.http.put(`${this.urlBase}/${id}`, cliente);
    }
    deleteCliente(id : number) : Observable<Object>{
        return this.http.delete(`${this.urlBase}/${id}`);
    }
}