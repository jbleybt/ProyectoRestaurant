import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaProductoComponent } from './producto/lista-producto.component';
import { DetalleProductoComponent } from './producto/detalle-producto.component';
import { NuevoProductoComponent } from './producto/nuevo-producto.component';
import { EditarProductoComponent } from './producto/editar-producto.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

// external
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { ListaClienteComponent } from './cliente/lista-cliente/lista-cliente.component';
import { EditarClienteComponent } from './cliente/editar-cliente/editar-cliente.component';
import { NuevoClienteComponent } from './cliente/nuevo-cliente/nuevo-cliente.component';
import { DetalleClienteComponent } from './cliente/detalle-cliente/detalle-cliente.component';
import { NuevoEmpleadoComponent } from './empleado/nuevo-empleado/nuevo-empleado.component';
import { ListaEmpleadoComponent } from './empleado/lista-empleado/lista-empleado.component';
import { EditarEmpleadoComponent } from './empleado/editar-empleado/editar-empleado.component';
import { DetalleEmpleadoComponent } from './empleado/detalle-empleado/detalle-empleado.component';
import { LoginComponent } from './auth/login.component';
import { RegistroComponent } from './auth/registro.component';
import { MenuComponent } from './menu/menu.component';
import { IndexComponent } from './index/index.component';
import { interceptorProvider } from './interceptors/prod-interceptor.service';
//import { LoginComponent } from './login/login/login.component';
//import { LogoutComponent } from './logout/logout/logout.component';
/*import { HeaderComponent } from './header/header/header.component';
import { FooterComponent } from './footer/footer/footer.component';
import { RegistroComponent } from './auth/registro.component';
import { MenuComponent } from './menu/menu.component';
import { IndexComponent } from './index/index.component';
*/

@NgModule({
  declarations: [
    AppComponent,
    ListaProductoComponent,
    DetalleProductoComponent,
    NuevoProductoComponent,
    EditarProductoComponent,
    ListaClienteComponent,
    EditarClienteComponent,
    NuevoClienteComponent,
    DetalleClienteComponent,
    NuevoEmpleadoComponent,
    ListaEmpleadoComponent,
    EditarEmpleadoComponent,
    DetalleEmpleadoComponent,
    LoginComponent,
    RegistroComponent,
    MenuComponent,
    IndexComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
