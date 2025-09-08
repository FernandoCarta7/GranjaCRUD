import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'nav-bar',
  imports: [],
  templateUrl: './nav-bar.html',
  styleUrl: './nav-bar.css'
})
export class NavBar {

  constructor(private router: Router) {

  }

  goToClientes() {
    this.router.navigate(['/listado-clientes']);
  }
  goToPorcinos() {
    this.router.navigate(['/listado-porcino']);
  }
}
