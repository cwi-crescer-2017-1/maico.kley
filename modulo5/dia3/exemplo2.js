var app = angular.module('myApp', []);
app.controller('myController', function($scope) {
  let aulas = [
  'OO',
  'HTML e CSS',
  'Javascript',
  'AngularJS',
  'Banco de Dados I'
  ];
  $scope.aulas=aulas;

  let instrutores = [
  {
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: true,
    aula: 'OO'
  }];
  $scope.instrutores=instrutores;
});
