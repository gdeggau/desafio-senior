import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-create-cliente',
  templateUrl: './create-cliente.component.html',
  styleUrls: ['./create-cliente.component.scss']
})
export class CreateClienteComponent implements OnInit {

  cliente: Cliente = new Cliente();
  submitted = false;

  constructor(private clienteService: ClienteService) { }

  ngOnInit() {
  }

  newCliente(): void {
    this.submitted = false;
    this.cliente = new Cliente();
  }

  save() {
    this.clienteService.createCliente(this.cliente)
      .subscribe(data => console.log(data), error => console.log(error));
    this.cliente = new Cliente();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
