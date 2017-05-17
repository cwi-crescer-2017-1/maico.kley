var app = angular.module('exercicio', []);
app.controller('exemplo', function($scope) {
    $scope.pokemon = {
      nome : "pikachu",
      cor : "amarelo",
      tipo : "eletrico"
    }
});
