var app = angular.module("deanery", []);
app.controller("AppCtrl", function ($scope, $http) {

    $scope.deaneries = [];
    $http.get('/api/deaneries').then(function (response) {
        $scope.deaneries = response.data;
    });

    this.insertDeanery= function insert() {
        var address = document.getElementById("address").value;
        var phoneNumber = document.getElementById("phoneNumber").value;
        var req = {
            method: 'POST',
            url: '/api/deanery/insert',
            data: {
                address: address,
                phoneNumber: phoneNumber
            }
        };
        // console.log(req);
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.deleteDeanery= function del(id) {
        $http.get("api/deanery/delete?id="+id).then(function (response) {
            window.location.reload();
        });
    };

    this.startUpdate = function startUpdate(id, address, phoneNumber) {
        document.getElementById("updateId").innerText = id;
        document.getElementById("updateAddress").value = address;
        document.getElementById("updatePhoneNumber").value = phoneNumber;
    };

    this.updateDeanery= function update() {
        var id = document.getElementById("updateId").innerText;
        var address = document.getElementById("updateAddress").value;
        var phoneNumber = document.getElementById("updatePhoneNumber").value;
        var req = {
            method: 'POST',
            url: "/api/deanery/update?id="+id,
            data: {
                address: address,
                phoneNumber: phoneNumber
            }
        };
        // console.log(req);
        $http(req).then(function (resp) {
            window.location.reload();
        });
    };

});