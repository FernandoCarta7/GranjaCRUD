import { Component } from '@angular/core';
import { Cliente } from '../model/Cliente';
import { CommonModule } from '@angular/common';
import { ClienteService } from '../servicios/Cliente.service';
import { Router } from '@angular/router';
import { CrearCliente } from "../crear-cliente/crear-cliente";
import { PorcinoService } from '../servicios/Porcino.service';


@Component({
  selector: 'listado-clientes',
  imports: [CommonModule, CrearCliente],
  templateUrl: './listado-clientes.html',
  styleUrl: './listado-clientes.css'
})
export class ListadoClientes {
  clientes: Cliente[];
  constructor(private clienteService: ClienteService, private router: Router, private porcinoService : PorcinoService) { }

  goToClientes() {
    this.router.navigate(['/listado-clientes']);
  }

  ngOnInit() {

    this.getListClientes();
  }
  private getListClientes() {
    this.clienteService.getClientes().subscribe(
      (response => {
        this.clientes = response
      })
    )
  }

  editCliente(cedula: String) {
    this.router.navigate(['editar-cliente', cedula])
  }

  deleteCliente(cedula: String) {
    
    this.clienteService.deleteCliente(cedula).subscribe(
      {
        next: () => this.getListClientes()

      }
    )
  }

  goToCrearPorcino( cedula : String ){
    this.router.navigate(['crear-porcino', cedula]);
  }

}
