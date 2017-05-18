var app = angular.module("myApp", []);
app.filter('mascada', function(){
  return function(nome){
    nome = nome.replace(/nunes/i, '$ '+ nome +' $');
    return nome;
  }
})
app.controller("myController", function($scope) {
  let instrutores = [{
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
  },
  {
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
  }
];
$scope.instrutores = instrutores;
});
