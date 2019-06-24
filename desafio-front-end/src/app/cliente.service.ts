import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private baseUrl = 'http://localhost:8080/desafio/clientes/';

  constructor(private http: HttpClient) { }

  createCliente(cliente: Object): Observable<Object> {
    return this.http.post(this.baseUrl, cliente);
  }

  updateCliente(id: number, value: any): Observable<Object> {
    return this.http.put(this.baseUrl + id, value);
  }

  deleteCliente(id: number): Observable<any> {
    return this.http.delete(this.baseUrl + id, { responseType: 'text' });
  }

  getClientesList(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
}