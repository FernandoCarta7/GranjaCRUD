import { Component } from '@angular/core';
import { PorcinoService } from '../servicios/Porcino.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Porcino } from '../model/Porcino';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'editar-porcino',
  imports: [FormsModule],
  templateUrl: './editar-porcino.html',
  styleUrl: './editar-porcino.css'
})
export class EditarPorcino {

  public id_porcino: number;
  public fecha_nacimiento: Date;
  public peso: number;
  public edad: number;
  public porcino;
  constructor( 
    private porcinoService : PorcinoService,
    private router : Router,
    private ruta : ActivatedRoute
  ){
    
  }

  ngOnInit() {
    this.id_porcino = this.ruta.snapshot.params['id_porcino'];
    this.porcinoService.getPorcinoById(this.id_porcino).subscribe(
      {
        next: (dato) => this.porcino = dato,
        error: (errores: any) => console.error(errores)
      }
    );
  }
  onSubmit(){
    this.guardarPorcino();
  }

  goToListadoPorcino(){
    this.router.navigate(['/listado-porcino'])
  }
  guardarPorcino(){
    console.log(this.porcino)
    this.porcinoService.editPorcino(this.id_porcino, this.porcino).subscribe({
      next : () => this.goToListadoPorcino()
    })
    
  }
}
