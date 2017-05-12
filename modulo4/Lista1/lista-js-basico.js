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
  var tamanho = x.length > 0 ? x[0] : "";
  for (let i = 1; i < x.length; i++) {
    if (tamanho.length<x[i].length) {
      tamanho = x[i];
    }
  }
  return tamanho;
}
//let manter a variavel apenas dentro do escopo
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
//Ex 6
 function queroCafe(mascada,preco){
   var menor = 0;
   for (var i = 0; i < (preco.length); i++) {
     for (var j = i+1; j < (preco.length); j++) {
       if (preco[i]>preco[j]) {
          menor = preco[i];
          preco[i]=preco[j];
          preco[j]=menor;
       }
     }
   }
   var batata = "";
   for (var i = 0; i < preco.length; i++) {
     if (mascada>=preco[i]) {
       batata += preco[i] +',';
     }
   }
   return batata;
}
