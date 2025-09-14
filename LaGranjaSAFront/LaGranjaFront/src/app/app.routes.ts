import { Routes } from '@angular/router';
import { ListadoPorcino } from './listado-porcino/listado-porcino';
import { ListadoClientes } from './listado-clientes/listado-clientes';
import { CrearCliente } from './crear-cliente/crear-cliente';
import { EditarCliente } from './editar-cliente/editar-cliente';
import { EditarPorcino } from './editar-porcino/editar-porcino';
import { CrearPorcino } from './crear-porcino/crear-porcino';

export const routes: Routes = [
    //Clientes
    { path: 'listado-clientes', component: ListadoClientes, title: 'Clientes' },
    { path: 'editar-cliente/:cedula', component: EditarCliente, title: 'Editar cliente' },
    { path: 'crear-cliente', component: CrearCliente },
    //Porcinos
    { path: 'listado-porcino', component: ListadoPorcino, title: 'Porcinos' },
    { path: 'editar-porcino/:id_porcino', component: EditarPorcino, title: 'Editar Porcino' },
    { path: 'crear-porcino', component: CrearPorcino, title: 'Crear Porcino' },
    { path: '', redirectTo: 'inicio', pathMatch: 'full' },
];
