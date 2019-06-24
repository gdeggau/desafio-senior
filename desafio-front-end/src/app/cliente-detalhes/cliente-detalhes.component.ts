import { Component, OnInit, Input } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { ClienteListaComponent } from '../cliente-lista/cliente-lista.component';

@Component({
  selector: 'app-cliente-detalhes',
  templateUrl: './cliente-detalhes.component.html',
  styleUrls: ['./cliente-detalhes.component.scss']
})
export class ClienteDetalhesComponent implements OnInit {

  @Input() cliente: Cliente;

  constructor(private clienteService: ClienteService, private listComponent: ClienteListaComponent) { }

  ngOnInit() {
  }

}
