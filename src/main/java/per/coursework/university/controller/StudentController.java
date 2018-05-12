package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.coursework.university.model.Student;
import per.coursework.university.service.student.StudentServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @RequestMapping("/students")
    List<Student> showStudents() throws SQLException {
        return studentService.getAll();
    }

    @PostMapping("/student/insert")
    Student insertStudent(@RequestBody Student student) throws SQLException {
        return studentService.insertStudent(student);
    }

    @GetMapping("/student/delete")
    void deleteStudent(@RequestParam("id") int id) throws SQLException {
        studentService.deleteStudent(id);
    }

    @GetMapping("/student/get")
    Student getStudentById(@RequestParam("id") int id) throws SQLException {
        return studentService.getStudent(id);
    }

    @RequestMapping("/student/update")
    Student updateStudent(@RequestBody Student student, @RequestParam("id") int id) throws SQLException {
        student.setId(id);
        return studentService.updateStudent(student);
    }
}
