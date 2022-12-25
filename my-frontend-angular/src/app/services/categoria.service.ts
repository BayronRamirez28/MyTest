import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../model/categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  baseURL = 'http://localhost:8083/categorias'

  constructor(private httpClient:HttpClient) { }

  public listarCategorias(): Observable<Categoria[]>{
    return this.httpClient.get<Categoria[]>(`${this.baseURL}/all`);
  }

  public crearCategoria(categoria:Categoria): Observable<any>{
    return this.httpClient.post<any>(`${this.baseURL}/create`, categoria);
  }

  public findId(id: number): Observable<Categoria>{
    return this.httpClient.get<Categoria>(`${this.baseURL}/${id}`);
  }

  public actualizarCategoria(id: number, categoria:Categoria): Observable<any>{
    return this.httpClient.put(`${this.baseURL}/update/${id}`, categoria);
  }
}
