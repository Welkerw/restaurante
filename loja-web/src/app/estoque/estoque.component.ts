import { Component, OnInit } from '@angular/core';

import { HttpClientJsonpModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EstoqueService } from  './estoque.service';
import { FormGroup } from '@angular/forms';
import { ProdutoService } from '../produto/produto.service';

@Component({
  selector: 'app-estoque',
  templateUrl: './estoque.component.html',
  styleUrls: ['./estoque.component.css'],
  providers: [ProdutoService]
})
export class EstoqueComponent implements OnInit {
  
    constructor(private service: EstoqueService, private produtoService: ProdutoService) { 
    
    }
    
      public estoques;
      public produtos;
      estoque: any;
      loja: any;
      
      ngOnInit() {
    
        this.estoques =  this.service.buscarTodos().subscribe(resposta => this.estoques = resposta);
      }
    
      criar(frm: FormGroup)
      {
          this.service.criar(this.estoque).subscribe(resposta => {
            var teste = resposta;
            frm.reset;
          });
      }
}
