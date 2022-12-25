import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lote } from '../model/lote';
import { Producto } from '../model/producto';

@Injectable({
  providedIn: 'root'
})
export class LoteService {

  baseURL = 'http://localhost:8083/lotes'

  constructor(private httpClient:HttpClient) { }

  public listarLotes(): Observable<Lote[]>{
    return this.httpClient.get<Lote[]>(`${this.baseURL}/all`);
  }

  public listarProductos(): Observable<Producto[]>{
    return this.httpClient.get<Producto[]>(`${this.baseURL}/productos`);
  }

  public crearLote(lote:Lote): Observable<any>{
    return this.httpClient.post<any>(`${this.baseURL}/create`, lote);
  }

  public findId(id: number): Observable<Lote>{
    return this.httpClient.get<Lote>(`${this.baseURL}/${id}`);
  }

  public actualizarLote(id: number, lote:Lote): Observable<any>{
    return this.httpClient.put(`${this.baseURL}/update/${id}`, lote);
  }

}
