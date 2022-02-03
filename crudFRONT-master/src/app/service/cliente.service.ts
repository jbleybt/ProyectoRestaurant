import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  clienteURL = 'http://localhost:8080/cliente/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Cliente[]> {
    return this.httpClient.get<Cliente[]>(this.clienteURL + 'lista');
  }

  public detail(id: number): Observable<Cliente> {
    return this.httpClient.get<Cliente>(this.clienteURL + `detail/${id}`);
  }

  public detailName(nombre: string): Observable<Cliente> {
    return this.httpClient.get<Cliente>(this.clienteURL + `detailname/${nombre}`);
  }

  public save(cliente: Cliente): Observable<any> {
    return this.httpClient.post<any>(this.clienteURL + 'create', cliente);
  }

  public update(id: number, cliente: Cliente): Observable<any> {
    return this.httpClient.put<any>(this.clienteURL + `updateCliente/${id}`, cliente);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.clienteURL + `delete/${id}`);
  }
}
