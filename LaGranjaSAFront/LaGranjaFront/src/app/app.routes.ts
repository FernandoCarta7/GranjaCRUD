import { Routes } from '@angular/router';
import { ListadoPorcino } from './listado-porcino/listado-porcino';
import { ListadoClientes } from './listado-clientes/listado-clientes';

export const routes: Routes = [
    // { path: 'inicio', component: Componente, title: 'Registro de puntuacion' },
    { path: 'listado-porcino', component: ListadoPorcino, title: 'Porcinos' },
    { path: 'listado-clientes', component: ListadoClientes, title: 'Clientes' },
    { path: '', redirectTo: 'inicio', pathMatch: 'full' },
];
