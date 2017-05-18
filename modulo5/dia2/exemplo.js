var app = angular.module("container", []);
app.controller("datas", function($scope) {
  $scope.clicar = clicar;
  function clicar() {
    $scope.datavalida = new Date($scope.entrada);
  };
});
