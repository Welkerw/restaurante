import { Injectable } from '@angular/core';

import { HttpClient  } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EstoqueService {

  req = 'http://localhost:8080/estoques/';
  
    constructor(private http: HttpClient) { }
  
    buscarTodos()
    {
         return this.http.get<Array<any>>(this.req);
    }
    criar(estoque : any)
    {
         return this.http.post(this.req, estoque);
    }
}
