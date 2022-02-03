import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { EmpleadoService } from 'src/app/service/empleado.service';
import { Empleado } from 'src/app/models/empleado';
import 'bootstrap/dist/css/bootstrap.min.css'
import {Md5} from 'ts-md5/dist/md5';

@Component({
  selector: 'app-nuevo-empleado',
  templateUrl: './nuevo-empleado.component.html',
  styleUrls: ['./nuevo-empleado.component.css']
})
export class NuevoEmpleadoComponent implements OnInit {

  nombre = '';
  apellido:string= '';
  tipodocumento:string='';
  numerodocumento:string='';
  correo:string='';
  password:string='';

  
  constructor(
    private empleadoService: EmpleadoService,
    private toastr: ToastrService,
    private router: Router
    ) { }


  ngOnInit() {
  }

  onCreate(): void {
    const md5=new Md5();

    const messageEncrypted=md5.appendStr(this.password).end();
    //console.log(messageEncrypted);

    const empleado = new Empleado(this.nombre, this.apellido,this.tipodocumento,this.numerodocumento,this.correo,messageEncrypted.toString());
    this.empleadoService.save(empleado).subscribe(
      data => {
        this.toastr.success('Empleado Creado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/listaEmpleados']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/listaEmpleados']);
      }
    );
  }

   


}
