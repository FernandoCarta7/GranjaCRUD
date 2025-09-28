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
  public cliente: Cliente;
  public cedula: String;
  public nombres: String;
  public apellidos: String;
  public direccion: String;
  public telefono: String;
  public showAlert: boolean = false;
  public mensaje: string = "";
  //this.cliente = new Cliente();
  constructor(private http: HttpClient,
    private clienteServicio: ClienteService,
    private router: Router
  ) {

  }

  onSubmit() {
   
    console.log(this.cliente)
    this.saveCliente();
    this.goToClientes();
  }

  goToClientes() {
    this.router.navigate(['/listado-clientes']);
  }
  guardarCliente() {
    this.cliente = new Cliente(this.cedula, this.nombres, this.apellidos, this.direccion, this.telefono);

    this.clienteServicio.addCliente(this.cliente).subscribe({
      next: (datos) => {
        this.mensaje = "Cliente guardado exitosamente ✅";
        this.showAlert = true;

        // ⏳ después de 2 segundos, redirige al listado
        setTimeout(() => {
          this.goToClientes();
        }, 2000);
        this.goToClientes();
      }, error: () => {
        this.mensaje = "❌ Error al guardar el cliente";
        this.showAlert = true;
      }
    })
  }
  saveCliente() {
    this.cliente = new Cliente(this.cedula, this.nombres, this.apellidos, this.direccion, this.telefono);
    console.log('Guardando cliente usando GraphQL');
    this.clienteServicio.saveCliente(this.cliente).subscribe({
      next: (datos) => {
        this.mensaje = "Cliente guardado exitosamente ✅";
        this.showAlert = true;

        // ⏳ después de 2 segundos, redirige al listado
        setTimeout(() => {
          this.goToClientes();
        }, 2000);
        this.goToClientes();
      }, error: () => {
        this.mensaje = "❌ Error al guardar el cliente";
        this.showAlert = true;
      }
    })
  }


}
