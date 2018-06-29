import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProdutoComponent } from './produto/produto.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EstoqueComponent } from './estoque/estoque.component';
import {SidebarModule} from './sidebar/sidebar.module';
import {NavbarModule} from './shared/navbar/navbar.module';
import {FooterModule} from './shared/footer/footer.module';
import {FixedPluginModule} from './shared/fixedplugin/fixedplugin.module';
import { ClienteComponent } from './cliente/cliente.component';



const appRoutes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    data: { title: 'Loja Nerus' }
  },
  {
    path: 'cliente',
    component: ClienteComponent,
    data: { title: 'Cliente' }
  },
  {
    path: 'produto',
    component: ProdutoComponent,
    data: { title: 'Loja' }
  },
  {
    path: 'estoque',
    component: EstoqueComponent,
    data: { title: 'estoque' }
  },
  { path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  }
];



@NgModule({
  declarations: [
    AppComponent,
    ClienteComponent,
    ProdutoComponent,
    HomeComponent,
    EstoqueComponent,
    ClienteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes, { enableTracing: true }
    ),
    SidebarModule,
    NavbarModule,
    FooterModule,
    FixedPluginModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
