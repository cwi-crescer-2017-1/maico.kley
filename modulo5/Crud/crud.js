var app = angular.module('myApp', []);
app.controller('myController', function($scope){
  let aulas = [{
    nome:'POO',
    id: 0
  },
  {
    nome:'HTML e CSS',
    id:1
  },
  {
    nome:'Banco de Dados I',
    id:2
  },
  {
    nome:'Javascript',
    id:3
  },
  {
    nome:'AngularJS',
    id:4
  }];
  $scope.aulas=aulas;

  $scope.incluir = function(novaAula){

    if($scope.meuForm.$invalid){
      return;
    }

    $scope.aulas.push({nome: novaAula, id: (aulas[aulas.length-1].id+1)});
    $scope.novaAula = ' ';
  }

  /*$scope.remover = function(aula){
    for(let i = 0; i < aulas.length; i++){
      if (aulas[i] === aula) {
        var validacao = i;
      }
    }
    $scope.aulas.splice(validacao, 1);
  }
  console.log($scope.aula);*/

  $scope.remover = function (index) {
    $scope.aulas.splice(index+1, 1);
  };

  instrutores = [{
    id: 0,
    nome: 'Bernardo',
    sobrenome: 'Bozak',
    idade: 28,
    email: 'bernardo@cwi.com.br',
    dandoAula: true,
    aula: [0],
    urlFoto: 'https://avatars2.githubusercontent.com/u/526075?v=3&s=400'
  },
  {
    id: 1,
    nome: 'André',
    sobrenome: 'Nunes',
    idade: 30,
    email: 'nunes@cwi.com.br',
    dandoAula: true,
    aula: [1],
    urlFoto: 'https://avatars0.githubusercontent.com/u/10319453?v=3&s=400'
  },
  {
    id: 2,
    nome: 'Pedro',
    sobrenome: 'Henrique',
    idade: 21,
    email: 'php@cwi.com.br',
    dandoAula: true,
    aula: [2],
    urlFoto: 'https://avatars2.githubusercontent.com/u/6934800?v=3&s=400'
  },
  {
    id: 3,
    nome: 'Éverton',
    sobrenome: 'Zanatta',
    idade: 24,
    email: 'zanatta@cwi.com.br',
    dandoAula: true,
    aula: [4],
    urlFoto: 'https://avatars0.githubusercontent.com/u/4175351?v=3&s=400'
  }];
  $scope.instrutores = instrutores;
});
