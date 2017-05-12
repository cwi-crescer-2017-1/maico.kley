//Ex 1
function daisyGame(x) {
  if (typeof x === typeof 3) {
    if (x%2==1) {
      return "Love me"
    } else if (x%2==0) {
      return "Love me not";
    }
  }
}
//Ex 2
function maiorTexto(x) {
  var tamanho = x[0];
  for (var i = 1; i < x.length; i++) {
    if (x[0].length<x[i].length) {
      tamanho = x[i];
    }
  }
  return tamanho;
}
//Ex 3
function instrutorQuerido(x) {
  for (var i = 0; i < x.length; i++) {
    console.log('olá querido instrutor', x[i]);
  }
}
function imprime(lista, funcao) {
  return typeof funcao === "function" && funcao(lista);
}
//Ex 4
function adicionar(x) {
   function adicionarInterno(y) {
      return somar(x, y);
   }
   return adicionarInterno;
}
function somar(a,b){
  return a+b;
}
//Ex 5
/*
inteiro Fibonacci (inteiro k)
{
se k = 1: devolvo 1;
se k = 2: devolvo 1;
devolvo Fibonacci(k - 1) + Fibonacci (k - 2);
}
*/
function fiboSum(x) {
  var retorno = 0;
  for (var i = 0; i <= x; i++) {
    retorno = retorno + fibo(i);
  }
  return retorno;
}
function fibo(x) {
  return (x < 2) ? x : fibo(x - 1) + fibo(x - 2);
}
