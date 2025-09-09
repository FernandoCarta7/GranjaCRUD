import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Cliente } from '../model/Cliente';
import { ClienteService } from '../servicios/Cliente.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'crear-cliente',
  imports: [CommonModule, FormsModule],
  templateUrl: './crear-cliente.html',
  styleUrl: './crear-cliente.css'
})
export class CrearCliente {
  public cliente : Cliente;
  public cedula: String;
  public nombres: String;
  public apellidos: String;
  public direccion: String;
  public telefono: String;
  //this.cliente = new Cliente();
  constructor(private http: HttpClient,
    private clienteServicio: ClienteService,
    private router: Router
  ) {

  }

  onSubmit() {
    console.log(this.cliente)
    this.guardarCliente();
  }

  goToClientes() {
    this.router.navigate(['/listado-clientes']);
  }
  guardarCliente() {
    this.cliente = new Cliente(this.cedula,this.nombres,this.apellidos,this.direccion,this.telefono);

    this.clienteServicio.addCliente(this.cliente).subscribe({
      next: (datos) => {
        this.goToClientes();
      }
    })
  }

}
