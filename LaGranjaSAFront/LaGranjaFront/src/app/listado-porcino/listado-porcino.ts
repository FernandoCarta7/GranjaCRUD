import { Component } from '@angular/core';
import { PorcinoService } from '../servicios/Porcino.service';
import { Router } from '@angular/router';
import { Porcino } from '../model/Porcino';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-listado-porcino',
  imports: [CommonModule],
  templateUrl: './listado-porcino.html',
  styleUrl: './listado-porcino.css'
})
export class ListadoPorcino {

  public porcinos: Porcino[];


  constructor(private porcinoService: PorcinoService, private router: Router) { }
  ngOnInit() {

    this.getListPorcinos();
  }

  private getListPorcinos() {
    this.porcinoService.getPorcinos().subscribe(
      (response => {
        this.porcinos = response
      })
    )
  }

  editPorcino(id_porcino: number) {
    this.router.navigate(['editar-porcino', id_porcino]);
  }

  deletePorcino(id_porcino: number) {
    this.porcinoService.deletePorcino(id_porcino).subscribe({
      next: () => this.getListPorcinos()
    })
  }

}
