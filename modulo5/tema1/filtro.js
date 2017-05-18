var app = angular.module("tema1", []);
app.controller("lista", function($scope) {
  $scope.pokemons = [
  {
    nome: 'Pikachu',
    tipo: 'Eletrico '
  },
  {
    nome: 'Mankey',
    tipo: 'Lutador'
  },
  {
    nome: 'Ekans',
    tipo: 'Veneno'
  },
  {
    nome: 'Pidgey',
    tipo: 'Voador'
  },
  {
    nome: 'Vulpix',
    tipo: 'Fogo'
  },
  {
    nome: 'Meowth',
    tipo: 'Normal'
  },
  {
    nome: 'Psyduck',
    tipo: 'Água'
  },
  {
    nome: 'Abra',
    tipo: 'Psiquico'
  },
  {
    nome: 'Machop',
    tipo: 'Lutador'
  },
  {
    nome: 'Geodude',
    tipo: 'Pedra'
  }]
});
