/**
 * @author Rashmi
 * @date Jan'04 2016
 * 
 */

app.controller('FBLoginModalCtrl', ['$scope', '$modalInstance', 'data','authFactory','$http','RestURL','$timeout', function ($scope, $modalInstance, data, authFactory,$http,RestURL,$timeout) {

    $scope.modalData = {};

    $scope.modalData.name = "";
    $scope.modalData.type = "";
    $scope.modalData.email = "";

    $scope.modalData.multiselectsettings = {
        scrollableHeight: '200px',
        scrollable: true
    };

    $scope.modalData.message = data;
    
    $scope.modalData.id = data;
    
    $scope.ok = function () {
        $modalInstance.close($scope.modalData);
    };

    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
    
   
		
}]);