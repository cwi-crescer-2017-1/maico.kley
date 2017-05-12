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
/*var calcular = function(funcao, a, b) {
  //return funcao(arguments[0], arguments[1])
  return typeof funcao === "function" && funcao(a, b);
}*/
function intrutorQuerido(x) {
  for (var i = 0; i < x.length; i++) {
    console.log('olá querido instrutor', x[i]);
  }
}
function imprime(lista, funcao) {  
  return typeof funcao === "function" && funcao(lista);
}
