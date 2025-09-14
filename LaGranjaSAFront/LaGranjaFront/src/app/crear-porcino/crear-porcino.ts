import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { PorcinoService } from '../servicios/Porcino.service';
import { Router } from '@angular/router';
import { Porcino } from '../model/Porcino';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'crear-porcino',
  imports: [FormsModule],
  templateUrl: './crear-porcino.html',
  styleUrl: './crear-porcino.css'
})
export class CrearPorcino {
  porcino: Porcino = new Porcino();

  public id_porcino: number;
  public raza: String;
  public fecha_nacimiento: Date;
  public peso: number;
  public edad: number;

  public showAlert: boolean = false;
  public mensaje: string = "";

  constructor(private http: HttpClient,
    private porcinoService: PorcinoService,
    private router: Router) {
  }
  goToPorcinos() {
    this.router.navigate(['/listado-porcino'])
  }

  guardarPorcino() {
   
    this.porcinoService.addPorcino(this.porcino).subscribe({
      next: () => {
        this.goToPorcinos()
        this.mensaje = "Porcino guardado exitosamente ✅";
        this.showAlert = true;
      }
    })
  }

  onSubmit(){
    this.guardarPorcino();
  }
}
