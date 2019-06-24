import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteListaComponent } from './cliente-lista/cliente-lista.component';
import { CreateClienteComponent } from './create-cliente/create-cliente.component';

const routes: Routes = [
  { path: '', redirectTo: 'cliente', pathMatch: 'full' },
  { path: 'clientes', component: ClienteListaComponent },
  { path: 'add', component: CreateClienteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
