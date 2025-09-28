import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable } from "rxjs";
import { Cliente } from "../model/Cliente";
import { Apollo, gql } from "apollo-angular";

@Injectable({
    providedIn: 'root'
})
export class ClienteService {

    private urlBase = "http://localhost:8080/inicio/getClientes";
    private urlGuardarClientes = "http://localhost:8080/inicio/saveCliente";
    private urlDelete = "http://localhost:8080/inicio/deleteCliente";
    private urlCliente = "http://localhost:8080/inicio/getClienteByCedula"
    private urlEditCliente = "http://localhost:8080/inicio/editarPaciente";
    private urlGraphQL = "http://localhost:8080/graphql";
    constructor(private http: HttpClient, private apollo: Apollo) { }

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
    /*--------------------------------------------------------*/
    /*--------------------GRAPHQL Clientes--------------------*/
    /*--------------------------------------------------------*/

    getClientesGraphQL(): Observable<Cliente[]> {
        return this.apollo
            .watchQuery<{ getClientes: Cliente[] }>({
                query: gql`
                    query {
                        getClientes {
                            cedula
                            nombres
                            apellidos
                            direccion
                            telefono
                            }
                    }
                    `
            })
            .valueChanges.pipe(
                map(result => {
                    console.log('Respuesta completa de Apollo:', result);
                    return result.data?.getClientes ?? []; // <- aquí se evita undefined
                })
            );
    }



    saveCliente(cliente: Cliente): Observable<any> {
        return this.apollo.mutate({
            mutation: gql`
      mutation ($cliente: ClienteInput!) {
        saveCliente(cliente: $cliente) {
          cedula
          nombres
          apellidos
          direccion
          telefono
        }
      }
    `,
            variables: {
                cliente: cliente
            },
            context: {
                uri: this.urlGraphQL,
            },
        }).pipe(
            map((result: any) => result.data.saveCliente)
        );
    }

    deleteClienteGraphQL(cedula: String): Observable<any> {
        return this.apollo.mutate({
            mutation: gql`
      mutation ($cedula: String!) {
        deleteCliente(cedula: $cedula)
      }
    `,
            variables: {
                cedula: cedula
            },
            context: {
                uri: this.urlGraphQL,
            },
        }).pipe(
            map((result: any) => result.data.deleteCliente)
        );
    }


    updateClienteGraphQL(cedula: String, cliente: any): Observable<any> {
        return this.apollo.mutate({
            mutation: gql`
            mutation ($cedula: String!, $cliente: ClienteInput!) {
                updateCliente(cedula: $cedula, cliente: $cliente) {
                cedula
                nombres
                apellidos
                direccion
                telefono
                }
            }
            `,
            variables: {
                cedula: cedula,
                cliente: cliente
            },
            context: {
                uri: this.urlGraphQL,
            },
        }).pipe(
            map((result: any) => result.data.updateCliente)
        );
    }
    /*--------------------------------------------------------------*/
    /*-------------------- FIN GRAPHQL Clientes--------------------*/
    /*-------------------------------------------------------------*/

}
