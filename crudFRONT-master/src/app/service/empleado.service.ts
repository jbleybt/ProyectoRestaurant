import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Empleado } from '../models/empleado';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  empleadoURL = 'http://localhost:8080/empleado/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Empleado[]> {
    return this.httpClient.get<Empleado[]>(this.empleadoURL + 'lista');
  }

  public detail(id: number): Observable<Empleado> {
    return this.httpClient.get<Empleado>(this.empleadoURL + `detail/${id}`);
  }

  public detailName(nombre: string): Observable<Empleado> {
    return this.httpClient.get<Empleado>(this.empleadoURL + `detailname/${nombre}`);
  }

  public save(empleado: Empleado): Observable<any> {
    return this.httpClient.post<any>(this.empleadoURL + 'create', empleado);
  }

  public update(id: number, empleado: Empleado): Observable<any> {
    return this.httpClient.put<any>(this.empleadoURL + `updateCliente/${id}`, empleado);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.empleadoURL + `delete/${id}`);
  }
}
