var app = angular.module("container", []);
app.controller("datas", function($scope) {
  $scope.clicar = clicar;
  function clicar() {

    if (angular.isUndefined($scope.entrada)) {
      return;
    }

    let pattern = '/(\d{2})\/(\d{2})\/(\d{4})/';
    let replace = '$1.$2.$3';
    let dataFormatada = $scope.entrada.replace(pattern, replace);
    console.log(dataFormatada);

    let dataObjeto = new Date(dataFormatada);

    $scope.datavalida = dataObjeto;
  };
});
