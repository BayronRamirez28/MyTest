import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from '../model/producto';
import { Observable } from 'rxjs';
import { Categoria } from '../model/categoria';
import { Proveedor } from '../model/proveedores';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  baseURL = 'http://localhost:8083/productos'

  constructor(private httpClient:HttpClient) { }

  public listarProductos(): Observable<Producto[]>{
    return this.httpClient.get<Producto[]>(`${this.baseURL}/all`);
  }

  public listarCategorias(): Observable<Categoria[]>{
    return this.httpClient.get<Categoria[]>(`${this.baseURL}/categorias`);
  }

  public listarProveedores(): Observable<Proveedor[]>{
    return this.httpClient.get<Proveedor[]>(`${this.baseURL}/proveedores`);
  }

  public crearProducto(producto:Producto): Observable<any>{
    return  this.httpClient.post<any>(`${this.baseURL}/create`,producto);
  }

  public findId(id: number): Observable<Producto>{
    return this.httpClient.get<Producto>(`${this.baseURL}/${id}`);
  }

  public actualizarProduct(id: number, producto:Producto): Observable<any>{
    return this.httpClient.put(`${this.baseURL}/update/${id}`, producto);
  }

}
