var app = angular.module("session", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.session = [];
    $http.get('api/session').then(function (response) {
        $scope.session = response.data;
    });

    this.startInsertSession = function () {
        $http.get('/api/curriculum').then(function (response) {
            var curriculum = response.data;
            var defaultOption = document.createElement("option");
            defaultOption.value="";
            defaultOption.text = "Виберіть предмет";
            defaultOption.disabled = true;
            defaultOption.selected = true;
            var selector = document.getElementById("curriculum");
            $(selector).empty();
            selector.add(defaultOption);
            for (var i = 0; i < curriculum.length; i++) {
                if(curriculum[i].subject.typeOfSubject.type == "Лекція") {
                    var option = document.createElement("option");
                    option.text = curriculum[i].subject.name + " - " + curriculum[i].semester + " семестер";
                    option.value = curriculum[i].id;
                    selector.add(option);
                }
            }
        });

        $http.get('/api/students').then(function (response) {
            var students = response.data;
            var defaultOption = document.createElement("option");
            defaultOption.value="";
            defaultOption.text = "Виберіть студента";
            defaultOption.disabled = true;
            defaultOption.selected = true;
            var selector = document.getElementById("student");
            $(selector).empty();
            selector.add(defaultOption);
            for (var i = 0; i < students.length; i++) {
                var option = document.createElement("option");
                option.text = students[i].name;
                option.value = students[i].id;
                selector.add(option);
            }
        });

    };

    this.insertSession = function add() {
        var mark = document.getElementById("mark").value;

        var indexStudent= document.getElementById("student").selectedIndex;
        var studentId = document.getElementById("student").options[indexStudent].value;

        var indexCurriculum= document.getElementById("curriculum").selectedIndex;
        var curriculumId= document.getElementById("curriculum").options[indexCurriculum].value;

        $http.get('/api/student/get?id='+ studentId).then(function (responseStudent) {
            var selectedStudent= responseStudent.data;
            $http.get('/api/curriculum/get?id='+ curriculumId).then(function (responseCurriculum) {
                var selectedCurriculum = responseCurriculum.data;
                var req = {
                    method: 'POST',
                    url: '/api/session/insert',
                    data: {
                        mark: mark,
                        curriculum: selectedCurriculum,
                        student: selectedStudent
                    }
                };
                console.log(req);
                $http(req).then(function (resp) {
                    window.location.reload();
                })
            });
        });
    };

    this.deleteSession= function del(id) {
        $http.get("api/session/delete?id="+id).then(function (response) {
            window.location.reload();
        });
    };

    this.startUpdateSession= function startUpdate(session) {
        $http.get('/api/curriculum').then(function (response) {
            var curriculum = response.data;
            var selector = document.getElementById("updateCurriculum");
            $(selector).empty();
            for (var i = 0; i < curriculum.length; i++) {
                if(curriculum[i].subject.typeOfSubject.type == "Лекція") {
                    var option = document.createElement("option");
                    if (curriculum[i].id == session.curriculum.id)
                        option.selected = 'selected';
                    option.text = curriculum[i].subject.name + " - " + curriculum[i].semester + " семестер";
                    option.value = curriculum[i].id;
                    selector.add(option);
                }
            }
        });

        $http.get('/api/students').then(function (response) {
            var students = response.data;
            var selector = document.getElementById("updateStudent");
            $(selector).empty();
            for (var i = 0; i < students.length; i++) {
                var option = document.createElement("option");
                if(students[i].id == session.student.id)
                    option.selected = 'selected';
                option.text = students[i].name;
                option.value = students[i].id;
                selector.add(option);
            }
        });

        document.getElementById("updateId").innerText = session.id;
        document.getElementById("updateMark").value = session.mark;

    };

    this.updateSession= function update() {
        var id = document.getElementById("updateId").innerText;
        var mark = document.getElementById("updateMark").value;

        var indexCurriculum= document.getElementById("updateCurriculum").selectedIndex;
        var curriculumId = document.getElementById("updateCurriculum").options[indexCurriculum].value;

        var indexStudent= document.getElementById("updateStudent").selectedIndex;
        var studentId= document.getElementById("updateStudent").options[indexStudent].value;

        $http.get('/api/curriculum/get?id='+ curriculumId).then(function (responseCurriculum) {
            var selectedCurriculum= responseCurriculum.data;
            $http.get('/api/student/get?id='+ studentId).then(function (responseStudent) {
                var selectedStudent= responseStudent.data;
                var req = {
                    method: 'POST',
                    url: '/api/session/update?id=' + id,
                    data: {
                        mark: mark,
                        curriculum: selectedCurriculum,
                        student: selectedStudent
                    }
                };
                console.log(req);
                $http(req).then(function (resp) {
                    window.location.reload();
                })
            });
        });
    };

});