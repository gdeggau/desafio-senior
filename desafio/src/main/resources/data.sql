insert into fornecedores (nm_fornecedor, ds_cnpj) values ('Oderco', '06578924536982');
insert into fornecedores (nm_fornecedor, ds_cnpj) values ('Hayamax', '63488924633382');
insert into fornecedores (nm_fornecedor, ds_cnpj) values ('Golden', '56327924656583');

insert into clientes (nm_cliente, ds_cpf) values ('Pedro', '03205684929');
insert into clientes (nm_cliente, ds_cpf) values ('Gustavo', '45605684875');
insert into clientes (nm_cliente, ds_cpf) values  ('Pedro', '07263984128');

insert into produtos (ds_produto, nr_valor_venda, nr_valor_compra) values ('Playstation 4', '2000', '800');
insert into produtos (ds_produto, nr_valor_venda, nr_valor_compra) values ('Chromecast', '200', '80');
insert into produtos (ds_produto, nr_valor_venda, nr_valor_compra) values ('Iphone X', '6000', '3500');
insert into produtos (ds_produto, nr_valor_venda, nr_valor_compra) values ('Lanterna', '60', '20');
insert into produtos (ds_produto, nr_valor_venda, nr_valor_compra) values ('Arcondicionado', '1000', '300');

--1
insert into pedidos (id_cliente) values ('2');
--2
insert into pedidos (id_cliente) values ('1');
--3
insert into pedidos (id_cliente) values ('2');

insert into pedidos_produtos (pedido_id_pedido, produtos_id_produto) values ('1','2');
insert into pedidos_produtos (pedido_id_pedido, produtos_id_produto) values ('1','3');

insert into pedidos_produtos (pedido_id_pedido, produtos_id_produto) values ('2','5');

insert into pedidos_produtos (pedido_id_pedido, produtos_id_produto) values ('3','4');
insert into pedidos_produtos (pedido_id_pedido, produtos_id_produto) values ('3','1');
insert into pedidos_produtos (pedido_id_pedido, produtos_id_produto) values ('3','2');

