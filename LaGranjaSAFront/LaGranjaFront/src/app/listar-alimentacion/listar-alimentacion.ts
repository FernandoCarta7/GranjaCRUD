import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Alimentacion } from '../model/Alimentacion';
import { AlimentacionService } from '../servicios/Alimentacion.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Raza } from '../model/Raza';

@Component({
  selector: 'listar-alimentacion',
  imports: [FormsModule, CommonModule],
  templateUrl: './listar-alimentacion.html',
  styleUrl: './listar-alimentacion.css'
})
export class ListarAlimentacion {
  
  public alimentos : Alimentacion[];
  public id_raza : number;
  constructor(private alimentacionService: AlimentacionService, private router: Router, private ruta: ActivatedRoute) { }


  ngOnInit() {
    //this.id_raza = this.ruta.snapshot.params['id_raza']
    //this.getListAlimentosByRaza(this.id_raza);
    this.getAlimentos();
  }
  getListAlimentosByRaza( id_raza : number) {
    this.alimentacionService.getAlimentacionByRaza( id_raza ).subscribe({
      next: (datos) => this.alimentos = datos
    })
  }
  getAlimentos(){
    this.alimentacionService.getAlimentacion().subscribe({
      next: (datos) => this.alimentos = datos
    })
  }
}
