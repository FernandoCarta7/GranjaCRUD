import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable } from "rxjs";
import { Porcino } from "../model/Porcino";
import { Apollo, gql } from "apollo-angular";
import { Cliente } from "../model/Cliente";

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
    constructor(private http: HttpClient, private apollo: Apollo) { }

    getPorcinoById(id_porcino: number) {
        console.log('getPorcinoById');
        console.log(id_porcino);
        return this.http.get<Porcino>(`${this.urlGetPorcino}/${id_porcino}`)
    }

    getPorcinos(): Observable<Porcino[]> {
        var lista = this.http.get<Porcino[]>(this.urlBase);
        console.log(lista);
        return this.http.get<Porcino[]>(this.urlBase);
    }
    addPorcino(porcino: Porcino): Observable<Object> {
        console.log(porcino);
        return this.http.post(this.agregarPorcino, porcino);
    }
    editPorcino(id: number, porcino: Porcino): Observable<Object> {
        return this.http.put(`${this.urlEditarPorcino}/${id}`, porcino);
    }
    deletePorcino(id_porcino: number): Observable<Object> {
        return this.http.delete(`${this.urlDelete}/${id_porcino}`);
    }
    getPorcinosGraphQL(): Observable<Porcino[]> {
        return this.apollo
            .watchQuery<{ getPorcinos: Porcino[] }>({
                query: gql`
              query {
                getPorcinos {
                    id_porcino
                    fecha_nacimiento
                    peso
                    edad
                    cliente {
                        cedula
                        nombres
                    }
                    raza {
                        
                        descripcion
                    }
                 }
                }
            `
            })
            .valueChanges.pipe(
                map(result => {
                    console.log('Respuesta completa de Apollo:', result);
                    return result.data?.getPorcinos ?? []; // <- aquí se evita undefined
                })
            );
    }
}