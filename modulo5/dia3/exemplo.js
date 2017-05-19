let app = angular.module('app',[]);

app.controller('MainController', function($scope){

  $scope.nomes=['Bernardo', 'Nunes'];

  $scope.incluir = function(novoNome){
    console.log($scope.meuForm);

    if($scope.meuForm.$invalid){
      return;
    }

    $scope.nomes.push(novoNome);
    $scope.novoNome = "";
  }
});
