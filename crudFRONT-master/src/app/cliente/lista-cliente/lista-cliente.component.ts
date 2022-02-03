import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente';
import { ToastrService } from 'ngx-toastr';
import { ClienteService } from 'src/app/service/cliente.service';
import { TokenService } from 'src/app/service/token.service';
//import { ProductoService } from '../service/producto.service';

@Component({
  selector: 'app-lista-cliente',
  templateUrl: './lista-cliente.component.html',
  styleUrls: ['./lista-cliente.component.css']
})
export class ListaClienteComponent implements OnInit {

  clientes: Cliente[] = [];
  roles: string[];
  isAdmin = false;

  constructor(
    private clienteService: ClienteService,
    private toastr: ToastrService,
    private tokenService: TokenService
    ) { }

  ngOnInit() {
    this.cargarClientes();
    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(rol => {
      if (rol === 'ROLE_ADMIN') {
        this.isAdmin = true;
      }
    });
  }

  cargarClientes(): void {
    this.clienteService.lista().subscribe(
      data => {
        this.clientes = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  borrar(id: number) {
    this.clienteService.delete(id).subscribe(
      data => {
        this.toastr.success('Cliente Eliminado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.cargarClientes();
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
      }
    );
  }
}
