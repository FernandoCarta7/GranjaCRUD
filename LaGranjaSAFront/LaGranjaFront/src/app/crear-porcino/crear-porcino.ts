import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { PorcinoService } from '../servicios/Porcino.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Porcino } from '../model/Porcino';
import { FormsModule } from '@angular/forms';
import { ClienteService } from '../servicios/Cliente.service';
import { Cliente } from '../model/Cliente';
import { RazaService } from '../servicios/RazaService.service';
import { Raza } from '../model/Raza';
import { switchMap } from 'rxjs';

@Component({
  selector: 'crear-porcino',
  imports: [FormsModule],
  templateUrl: './crear-porcino.html',
  styleUrl: './crear-porcino.css'
})
export class CrearPorcino {
  porcino: Porcino;
  public cedula: string;

  public descripcion: String;

  public showAlert: boolean = false;
  public mensaje: string = "";

  public cliente: Cliente;
  public raza: Raza;

  constructor(private http: HttpClient,
    private porcinoService: PorcinoService,
    private router: Router,
    private ruta: ActivatedRoute,
    private clienteService: ClienteService,
    private razaService: RazaService

  ) {
    this.descripcion = "";
    //this.raza = new Raza("",null);
    this.porcino = new Porcino(new Date, 0.0)
  }

  ngOnInit() {
    this.cedula = this.ruta.snapshot.params['cedula'];
    this.clienteService.getCliente(this.cedula).subscribe(
      {
        next: (dato) => this.cliente = dato,
        error: (errores: any) => console.error(errores)
      }
    );
  }
  goToPorcinos() {
    this.router.navigate(['/listado-porcino'])
  }

  guardarPorcino() {
  this.razaService.getRaza(this.descripcion).pipe(
    switchMap((raza) => {
      this.porcino.raza = raza;
      this.porcino.cliente = this.cliente;
      return this.porcinoService.addPorcino(this.porcino);
    })
  ).subscribe({
    next: () => {
      this.goToPorcinos();
      this.mensaje = "Porcino guardado exitosamente ✅";
      this.showAlert = true;
    },
    error: (err) => console.error("Error al guardar porcino", err)
  });
}


  onSubmit() {
    this.guardarPorcino();
  }
}
