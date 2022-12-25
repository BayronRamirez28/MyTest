import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proveedor } from '../model/proveedores';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {

  baseURL = 'http://localhost:8083/proveedores'

  constructor(private httpClient:HttpClient) { }

  public listarProveedores(): Observable<Proveedor[]>{
    return this.httpClient.get<Proveedor[]>(`${this.baseURL}/all`);
  }

  public crearProveedor(proveedor:Proveedor): Observable<any>{
    return this.httpClient.post<any>(`${this.baseURL}/create`, proveedor);
  }

  public findId(id: number): Observable<Proveedor>{
    return this.httpClient.get<Proveedor>(`${this.baseURL}/${id}`);
  }

  public actualizarProveedor(id: number, proveedor:Proveedor): Observable<any>{
    return this.httpClient.put(`${this.baseURL}/update/${id}`, proveedor);
  }
}
