import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListaProductoComponent } from './producto/lista-producto.component';
import { DetalleProductoComponent } from './producto/detalle-producto.component';
import { NuevoProductoComponent } from './producto/nuevo-producto.component';
import { EditarProductoComponent } from './producto/editar-producto.component';

import { ListaClienteComponent } from './cliente/lista-cliente/lista-cliente.component';
import { NuevoClienteComponent } from './cliente/nuevo-cliente/nuevo-cliente.component';
import { EditarClienteComponent } from './cliente/editar-cliente/editar-cliente.component';
import { DetalleClienteComponent } from './cliente/detalle-cliente/detalle-cliente.component';

import { ListaEmpleadoComponent } from './empleado/lista-empleado/lista-empleado.component';
import { NuevoEmpleadoComponent } from './empleado/nuevo-empleado/nuevo-empleado.component';
import { EditarEmpleadoComponent } from './empleado/editar-empleado/editar-empleado.component';
import { DetalleEmpleadoComponent } from './empleado/detalle-empleado/detalle-empleado.component';
//import { AuthGaurdService } from './service/auth-gaurd.service';
//import { LoginComponent } from './login/login/login.component';
//import { LogoutComponent } from './logout/logout/logout.component';
import { IndexComponent } from './index/index.component';
import { LoginComponent } from './auth/login.component';
import { RegistroComponent } from './auth/registro.component';
import { ProdGuardService as guard } from './guards/prod-guard.service';

const routes: Routes = [
   
/*
  {path: '/',component: IndexComponent},
  {path: 'login',component: LoginComponent},
  {path: 'registro',component: RegistroComponent },
  
  {path: 'listaProductos', component: ListaProductoComponent},//canActivate:[AuthGaurdService]
  {path: 'detalle/:id', component: DetalleProductoComponent},
  {path: 'nuevo', component: NuevoProductoComponent},
  {path: 'editar/:id', component: EditarProductoComponent},
  
  {path: 'listaClientes', component: ListaClienteComponent},
  {path: 'detalleCliente/:id', component: DetalleClienteComponent},
  {path: 'nuevoCliente', component: NuevoClienteComponent},
  {path: 'editarCliente/:id', component: EditarClienteComponent},

  {path: 'listaEmpleados', component: ListaEmpleadoComponent},
  {path: 'detalleEmpleado/:id', component: DetalleEmpleadoComponent},
  {path: 'nuevoEmpleado', component: NuevoEmpleadoComponent},
  {path: 'editarEmpleado/:id', component: EditarEmpleadoComponent},
  
  //{ path: 'login', component: LoginComponent },
  //{ path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService] },
  {path: '**', redirectTo: '', pathMatch: 'full'}

  */

  { path: '', component: IndexComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'lista', component: ListaProductoComponent, canActivate: [guard], data: { expectedRol: ['admin', 'user'] } },
  { path: 'detalle/:id', component: DetalleProductoComponent, canActivate: [guard], data: { expectedRol: ['admin', 'user'] } },
  { path: 'nuevo', component: NuevoProductoComponent, canActivate: [guard], data: { expectedRol: ['admin'] } },
  { path: 'editar/:id', component: EditarProductoComponent, canActivate: [guard], data: { expectedRol: ['admin'] } },

  {path: 'listaClientes', component: ListaClienteComponent,canActivate: [guard], data: { expectedRol: ['admin', 'user'] } },
  {path: 'detalleCliente/:id', component: DetalleClienteComponent,canActivate: [guard], data: { expectedRol: ['admin', 'user'] } },
  {path: 'nuevoCliente', component: NuevoClienteComponent,canActivate: [guard], data: { expectedRol: ['admin', 'user'] } },
  {path: 'editarCliente/:id', component: EditarClienteComponent,canActivate: [guard], data: { expectedRol: ['admin', 'user'] } },


  { path: '**', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
