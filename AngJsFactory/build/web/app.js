var fruitsApp = angular.module('fruitsApp', []);

fruitsApp.factory('fruitsFactory', function($http) {
    return {
        getFruitsAsync: function(callback) {
            $http.get('fruits.json').success(callback);
        }
    };
});

fruitsApp.controller('fruitsController', function($scope, fruitsFactory) {
    fruitsFactory.getFruitsAsync(function(results) {
        console.log('fruitsController async returned value');
        $scope.fruits = results.fruits;
    });
});