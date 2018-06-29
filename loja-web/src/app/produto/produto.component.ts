import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormsModule } from '@angular/forms';

import { ProdutoService } from  './produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
  
})
export class ProdutoComponent implements OnInit {
  
  constructor(private service: ProdutoService) { 
    
      }
    
      public produtos;
      produto: any;
    
      ngOnInit() {
    
        this.produto = {};
        this.produtos =  this.service.buscarTodos().subscribe(resposta => this.produtos = resposta);
    
      }
    
      criar(frm: FormGroup)
      {
          this.service.criar(this.produto).subscribe(resposta => {
            frm.reset;
          });
      }
    

}
