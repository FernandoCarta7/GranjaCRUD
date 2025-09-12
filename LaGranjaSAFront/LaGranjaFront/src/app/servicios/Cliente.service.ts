import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Cliente } from "../model/Cliente";

@Injectable({
    providedIn: 'root'
})
export class ClienteService {

    private urlBase = "http://localhost:8080/inicio/getClientes";
    private urlGuardarClientes = "http://localhost:8080/inicio/guardarCliente";
    private urlDelete = "http://localhost:8080/inicio/deleteCliente";
    private urlCliente = "http://localhost:8080/inicio/getClienteByCedula"
    private urlEditCliente = "http://localhost:8080/inicio/editarPaciente";
    constructor(private http: HttpClient) { }

    getCliente(cedula: String) {
        return this.http.get<Cliente>(`${this.urlCliente}/${cedula}`)
    }
    getClientes(): Observable<Cliente[]> {
        return this.http.get<Cliente[]>(this.urlBase);
    }
    addCliente(cliente: Cliente): Observable<Object> {
        return this.http.post(this.urlGuardarClientes, cliente);
    }
    editCliente(cedula: String, cliente: Cliente): Observable<Object> {
        return this.http.put(`${this.urlEditCliente}/${cedula}`, cliente);
    }
    deleteCliente(cedula: String): Observable<Object> {
        return this.http.delete(`${this.urlDelete}/${cedula}`);
    }



}