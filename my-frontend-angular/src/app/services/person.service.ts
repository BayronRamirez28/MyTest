import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private httpClient: HttpClient) { }

  public registrarPersona(person:any){
    return this.httpClient.post(`${baseUrl}/personas/save`,person);
  }
}
