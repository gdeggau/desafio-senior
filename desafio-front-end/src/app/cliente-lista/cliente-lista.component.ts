import { Observable } from "rxjs";
import { ClienteService } from "./../cliente.service";
import { Cliente } from "./../cliente";
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cliente-lista',
  templateUrl: './cliente-lista.component.html',
  styleUrls: ['./cliente-lista.component.scss']
})
export class ClienteListaComponent implements OnInit {

  clientes: Observable<Cliente>;

  constructor(private clienteService: ClienteService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.clientes = this.clienteService.getClientesList();
  }

  deleteCliente(id: number) {
    this.clienteService.deleteCliente(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

}
