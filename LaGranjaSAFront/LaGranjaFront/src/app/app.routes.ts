import { Routes } from '@angular/router';
import { ListadoPorcino } from './listado-porcino/listado-porcino';
import { ListadoClientes } from './listado-clientes/listado-clientes';
import { CrearCliente } from './crear-cliente/crear-cliente';
import { EditarCliente } from './editar-cliente/editar-cliente';
import { EditarPorcino } from './editar-porcino/editar-porcino';
import { CrearPorcino } from './crear-porcino/crear-porcino';
import { ListarAlimentacion } from './listar-alimentacion/listar-alimentacion';

export const routes: Routes = [
    //Clientes
    { path: 'listado-clientes', component: ListadoClientes, title: 'Clientes' },
    { path: 'editar-cliente/:cedula', component: EditarCliente, title: 'Editar cliente' },
    { path: 'crear-cliente', component: CrearCliente },
    //Porcinos
    { path: 'listado-porcino', component: ListadoPorcino, title: 'Porcinos' },
    { path: 'editar-porcino/:id_porcino', component: EditarPorcino, title: 'Editar Porcino' },
    { path: 'crear-porcino/:cedula', component: CrearPorcino, title: 'Crear Porcino' },

    //listar-alimentacion
    { path: 'listar-alimentacion', component: ListarAlimentacion, title: 'Alimentos' },

    { path: '', redirectTo: 'inicio', pathMatch: 'full' },
];
