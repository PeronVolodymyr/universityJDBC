package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
