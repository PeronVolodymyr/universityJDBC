var app = angular.module("chair", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.chairs = [];
    $http.get('/api/chairs').then(function (response) {
        $scope.chairs = response.data;
        // console.log(response);
    });

    this.startInsertChair= function () {
        $http.get('/api/departments').then(function (response) {
            var departments = response.data;
            var defaultOption = document.createElement("option");
            defaultOption.value="";
            defaultOption.text = "Виберіть факультет";
            defaultOption.disabled = true;
            defaultOption.selected = true;
            var selector = document.getElementById("department");
            $(selector).empty();
            selector.add(defaultOption);
            for (var i = 0; i < departments.length; i++) {
                var option = document.createElement("option");
                option.text = departments[i].name;
                option.value = departments[i].id;
                selector.add(option);
            }
        });
    };

    this.insertChair = function add() {
        var name = document.getElementById("name").value;
        var headOfChair = document.getElementById("headOfChair").value;

        var indexDepartment= document.getElementById("department").selectedIndex;
        var departmentId = document.getElementById("department").options[indexDepartment].value;

        $http.get('/api/department/get?id='+departmentId).then(function (response) {
            var selectedDepartment= response.data;
            var req = {
                method: 'POST',
                url: '/api/chair/insert',
                data: {
                    name: name,
                    headOfChair: headOfChair,
                    department: selectedDepartment
                }
            };
            console.log(req);
            $http(req).then(function (resp) {
                window.location.reload();
            })
        });
    };

    this.deleteChair = function del(id) {
        $http.get("api/chair/delete?id="+id).then(function (response) {
            window.location.reload();
        });
    };

    this.startUpdateChair = function startUpdate(id, name, headOfChair, department) {
        $http.get('/api/departments').then(function (response) {
            var departments = response.data;
            var selector = document.getElementById("updateDepartment");
            $(selector).empty();
            for (var i = 0; i < departments.length; i++) {
                var option = document.createElement("option");
                if (departments[i].id == department.id){
                    option.selected = 'selected';
                }
                option.text = departments[i].name;
                option.value = departments[i].id;
                selector.add(option);
            }
        });
        document.getElementById("updateId").innerText = id;
        document.getElementById("updateName").value = name;
        document.getElementById("updateHeadOfChair").value = headOfChair;
    };

    this.updateChair = function update() {
        var id = document.getElementById("updateId").innerText;
        var name = document.getElementById("updateName").value;
        var headOfChair = document.getElementById("updateHeadOfChair").value;

        var indexDepartment = document.getElementById("updateDepartment").selectedIndex;
        var departmentId = document.getElementById("updateDepartment").options[indexDepartment].value;

        $http.get('/api/department/get?id='+departmentId).then(function (response) {
            var selectedDepartment = response.data;
            var req = {
                method: 'POST',
                url: 'api/chair/update?id='+id,
                data: {
                    name: name,
                    headOfChair: headOfChair,
                    department: selectedDepartment
                }
            };
            $http(req).then(function (resp) {
                window.location.reload();
            })
        });
    };
});