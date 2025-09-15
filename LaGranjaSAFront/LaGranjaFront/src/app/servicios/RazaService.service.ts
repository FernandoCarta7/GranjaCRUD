import { HttpClient } from "@angular/common/http";
import { Raza } from "../model/Raza";
import { Injectable } from "@angular/core";
@Injectable({
    providedIn: 'root'
})
export class RazaService{
    private urlBase = "http://localhost:8080/inicio/getRaza";
    
    constructor(private http: HttpClient) { }

    getRaza(descripcion: String) {
        return this.http.get<Raza>(`${this.urlBase}/${descripcion}`)
    }
    
}