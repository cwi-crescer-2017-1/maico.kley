select * from Pedido;
select * from Cliente;
select * from Cidade;
select * from Produto;
select * from PedidoItem;
begin transaction
commit
rollback
--1
select top(1) substring(cli.Nome,0,CHARINDEX(' ',cli.Nome)),--seleciona a sequencia de caracteres até o primeiro espaço
			  count(ped.IDPedido) as TotalOcorrencias--faz a contagem do total de pedidos de um idcliente
from Cliente cli
inner join pedido ped on cli.IDCliente=ped.IDCliente
group by cli.Nome
order by TotalOcorrencias desc
/*
select cli.Nome,
	   ped.IDPedido
from Cliente cli
inner join pedido ped on cli.IDCliente=ped.IDCliente
group by cli.Nome, ped.IDPedido
order by cli.Nome asc
*/

--2
select count(idpedido) as Quantidade,
	   sum(valorpedido) as ValorPedido
from Pedido
where DATEPART(month,DataPedido)=04
  and DATEPART(YEAR,DataPedido)=2017

--3
--refazer
select * from (
select top(1) cid.UF,
	   count(cli.IDCliente) as TotalClientes
from cidade cid
inner join cliente cli on cid.IDCidade=cli.IDCidade
group by cid.UF
order by TotalClientes asc ) as menosClientes
union
select * from (
select top(1) cid.UF,
	   count(cli.IDCliente) as TotalClientes
from cidade cid
inner join cliente cli on cid.IDCidade=cli.IDCidade
group by cid.UF
order by TotalClientes desc) as maisClientes

--4
insert into Produto values ('Galocha Maragato', CURRENT_TIMESTAMP, 35.67, 77.95, 'A')

--5
select top(1) prod.nome as NomeProduto,
	   ISNULL(count(ped.idpedido),0) as PedidosDoItem
from Produto prod
left join PedidoItem ped on prod.IDProduto=ped.IDProduto
group by prod.nome
order by PedidosDoItem asc

--6
select top(30) prod.nome as NomeProduto,
	   pedi.Quantidade * (prod.PrecoVenda  - prod.PrecoCusto) as LucroProduto
from Produto prod
inner join PedidoItem pedi on prod.IDProduto=pedi.IDProduto
inner join Pedido ped on ped.IDPedido=pedi.IDProduto
where datepart(year, ped.Datapedido) = 2016 
order by LucroProduto desc

