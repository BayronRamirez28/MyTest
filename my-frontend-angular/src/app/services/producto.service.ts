import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { Producto } from '../model/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(private http:HttpClient) { }

  public listarProductos(){
    return this.http.get(`${baseUrl}/productos/all`);
  }

  public listarCategorias(){
    return this.http.get(`${baseUrl}/productos/categorias`);
  }

  public listarProveedores(){
    return this.http.get(`${baseUrl}/productos/proveedores`);
  }

  public crearProducto(producto:Producto){
    return  this.http.post(`${baseUrl}/productos/create`,producto);
  }

}
