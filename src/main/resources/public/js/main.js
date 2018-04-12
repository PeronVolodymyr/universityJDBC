var app = angular.module("university", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.deaneries = [];
    $http.get('/api/deaneries').then(function (response) {
        $scope.deaneries = response.data;
    });

    $scope.departments = [];
    $http.get('/api/departments').then(function (response) {
        $scope.departments = response.data;
    });

    $scope.chairs = [];
    $http.get('/api/chairs').then(function (response) {
        $scope.chairs = response.data;
          // console.log(response);
    });

    $scope.categoriesOfTeacher = [];
    $http.get('/api/categories of teacher').then(function (response) {
        $scope.categoriesOfTeacher = response.data;
    });

    $scope.typesOfSubject = [];
    $http.get('/api/types of subject').then(function (response) {
        $scope.typesOfSubject = response.data;
    });

    $scope.formsOfControl = [];
    $http.get('/api/forms of control').then(function (response) {
        $scope.formsOfControl = response.data;
    });

    $scope.groups = [];
    $http.get('/api/groups').then(function (response) {
        $scope.groups = response.data;
    });

    $scope.students = [];
    $http.get('/api/students').then(function (response) {
        $scope.students = response.data;
    });

    $scope.diplomas = [];
    $http.get('/api/diplomas').then(function (response) {
        $scope.diplomas = response.data;
    });

    $scope.doctoralDissertations = [];
    $http.get('/api/doctoral dissertations').then(function (response) {
        $scope.doctoralDissertations = response.data;

    });

    $scope.candidatesDissertations = [];
    $http.get('/api/candidates dissertations').then(function (response) {
        $scope.candidatesDissertations = response.data;
    });

    $scope.teachers = [];
    $http.get('api/teachers').then(function (response) {
        $scope.teachers = response.data;
    });

    $scope.subjects = [];
    $http.get('api/subjects').then(function (response) {
        $scope.subjects = response.data;
    });

    $scope.curriculum = [];
    $http.get('api/curriculum').then(function (response) {
        $scope.curriculum = response.data;
    });

    $scope.session = [];
    $http.get('api/session').then(function (response) {
        $scope.session = response.data;
    });





    // this.delstud = function del(id) {
    //     $http.get('/api/student/del?id='+id).then(function (response){
    //         //  $http.get('http://localhost:8080/api/students').then(function (response){
    //         // $scope.students=response.data;
    //         window.alert('Student ' + response.data.lastName + ' ' + response.data.firstName + ' has been succesfully deleted!');
    //         window.location.reload();9
    //     });
    // }
    //
    // $scope.groups = [];
    // $http.get('/api/groups').then(function (response){
    //     //  $http.get('http://localhost:8080/api/students').then(function (response){
    //     $scope.groups=response.data;
    //     console.log(response);
    // });
    //
    //*
    this.delchair = function del(id) {
        $http.get('/api/chair/del?id=' + id).then(function (response) {
            window.alert('Chair ' + ' ' + response.data.name + ' ' + response.data.id + ' ' + response.data.abr + ' ' + ' has been succesfully deleted!');
            window.location.reload();
        });
    };


    this.insertchair = function () {
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var abr = document.getElementById("abr").value;
        var req = {
            method: 'POST',
            url: '/api/chair/insert',
            data: {
                id: id,
                name: name,
                abr: abr
            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };
    $scope.showInsert = true;
    $scope.showUpdate = false;
    $scope.disabledId = false;
    var chair;
    this.hideInsertButton = function (item) {
        document.getElementById("id").value = item.id;
        document.getElementById("name").value = item.name;
        document.getElementById("abr").value = item.abr;
        $scope.disabledId = true;
        chair = item;
        $scope.showInsert = false;
        $scope.showUpdate = true;
    };

    this.cancelUpdate = function () {
        $scope.showInsert = true;
        $scope.showUpdate = false;
        window.location.reload();
    };

    this.updatechair = function () {
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var abr = document.getElementById("abr").value;
        var req = {
            method: 'POST',
            url: '/api/chair/update',
            data: {
                id: id,
                name: name,
                abr: abr
            }
        };
        // console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        });

    };
    $scope.showInsert = true;
    $scope.showUpdate = false;
    $scope.disabledId = false;


});

