import { Injectable } from '@angular/core';

import { HttpClient  } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  req = 'http://localhost:8080/produtos/';
  
    constructor(private http: HttpClient) { }
  
    buscarTodos()
    {
         return this.http.get<Array<any>>(this.req);
    }
    criar(produto : any)
    {
         return this.http.post(this.req, produto);
    }
}
