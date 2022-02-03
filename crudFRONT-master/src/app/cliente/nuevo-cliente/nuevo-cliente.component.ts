import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/service/cliente.service';

@Component({
  selector: 'app-nuevo-cliente',
  templateUrl: './nuevo-cliente.component.html',
  styleUrls: ['./nuevo-cliente.component.css']
})
export class NuevoClienteComponent implements OnInit {

  nombre = '';
  apellido:string= '';
  tipodocumento:string='';
  numerodocumento:string='';
  correo:string='';


  constructor(
    private clienteService: ClienteService,
    private toastr: ToastrService,
    private router: Router
    ) { }

  ngOnInit() {
  }

  onCreate(): void {
    const cliente = new Cliente(this.nombre, this.apellido,this.tipodocumento,this.numerodocumento,this.correo);
    this.clienteService.save(cliente).subscribe(
      data => {
        this.toastr.success('Cliente Creado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/listaClientes']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/listaClientes']);
      }
    );
  }

}
