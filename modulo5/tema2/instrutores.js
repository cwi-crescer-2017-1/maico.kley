var app = angular.module("myApp", []);

app.filter('lpad', function(){
  return function(numero){
    return numero.toString().padStart(2, '0');
  }
})
app.filter('upper', function(){
  return function(aula){
    return aula.toUpperCase();
  }
})
app.filter('mascada', function(){
  return function(nome){
    nome = nome.replace(/nunes/i, '$ '+ nome +' $');
    return nome;
  }
})
app.controller("myController", function($scope) {
  let instrutores = [{
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  },
  {
    nome: 'Bernardo',
    aula: [{
        numero: 1,
        nome: 'OO'
      },
      {
        numero: 4,
        nome: 'Javascript'
      }
    ]
  },
  {
    nome: 'Nunes',
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  }
];
$scope.instrutores = instrutores;
console.log($scope.instrutores);

let aulas = [];
  instrutores.filter(instrutor=>{instrutor.aula.filter(indice=>{
  aulas.push({numero : indice.numero, aula: indice.nome , nome: instrutor.nome})}
)});
$scope.instrutores = aulas;
console.log($scope.instrutores);
});
