import { Component } from '@angular/core';
import { Cliente } from '../model/Cliente';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ClienteService } from '../servicios/Cliente.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-cliente',
  imports: [CommonModule, FormsModule],
  templateUrl: './editar-cliente.html',
  styleUrl: './editar-cliente.css'
})
export class EditarCliente {

  constructor(private clienteServicio: ClienteService,
    private router: Router,
    private ruta: ActivatedRoute
  ) { }

  cliente: Cliente;
  public cedula: String;
  public nombres: String;
  public apellidos: String;
  public direccion: String;
  public telefono: String;

  onSubmit() {
    this.guardarCliente();
  }

  ngOnInit() {
    this.cedula = this.ruta.snapshot.params['cedula'];

    this.clienteServicio.getCliente(this.cedula).subscribe({
      next: (dato) => this.cliente = dato,
      error: (errores: any) => console.error(errores)
    })
  }

  goToClientes() {
    this.router.navigate(['/listado-clientes']);
  }
  guardarCliente() {
    console.log('Cedula: ' + this.cedula)
    this.clienteServicio.editCliente(this.cedula, this.cliente).subscribe(
      {
        next: () => this.goToClientes(),
        error: (errores) => console.error(errores)
      }
    )
  }

}
