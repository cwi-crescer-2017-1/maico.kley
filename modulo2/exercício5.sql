select emp.NomeEmpregado,
	   ger.NomeEmpregado,
	   dep.NomeDepartamento
from empregado emp
inner join empregado ger on emp.IDGerente = ger.IDEmpregado
inner join Departamento dep on emp.IDDepartamento = dep.IDDepartamento

 
select * from empregado

select * from Departamento

select top(1) dep.IDDepartamento,
	   dep.NomeDepartamento,
	   max(emp.salario) as Salario
from Departamento dep
inner join empregado emp on emp.IDDepartamento = dep.IDDepartamento
group by dep.IDDepartamento,
		 dep.NomeDepartamento
order by salario desc

select * into EmpregadoCopia from Empregado

begin transaction

update emp
set emp.Salario=Salario*1.173
from Empregado as emp
inner join Departamento dep on emp.IDDepartamento = dep.IDDepartamento
where DEP.Localizacao='SAO PAULO';

select * from empregado
union
select * from EmpregadoCopia

commit

select * from Cidade

select cid.Nome,
	   cid.UF
from cidade cid
inner join cidade dup on cid.nome=dup.nome 
					 and cid.uf=dup.uf
					 and cid.IDCidade!=dup.IDCidade
order by cid.Nome


update cid
set cid.Nome=cid.Nome+'*'
from cidade cid
inner join cidade dup on cid.nome=dup.nome 
					 and cid.uf=dup.uf
					 and cid.IDCidade!=dup.IDCidade
where cid.IDCidade>dup.IDCidade

select * from Cidade
union
select * from cidadeaux
