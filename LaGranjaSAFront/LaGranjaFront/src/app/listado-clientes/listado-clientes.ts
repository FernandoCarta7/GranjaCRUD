import { Component } from '@angular/core';
import { Cliente } from '../model/Cliente';
import { CommonModule } from '@angular/common';
import { ClienteService } from '../servicios/Cliente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'listado-clientes',
  imports: [CommonModule],
  templateUrl: './listado-clientes.html',
  styleUrl: './listado-clientes.css'
})
export class ListadoClientes {
  clientes: Cliente[];
  constructor(private clienteService: ClienteService, private router: Router) { }
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

}
