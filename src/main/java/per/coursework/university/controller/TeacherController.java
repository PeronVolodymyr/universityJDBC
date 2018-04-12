package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.Teacher;
import per.coursework.university.service.teacher.TeacherServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {
    @Autowired
    private TeacherServiceImpl teacherService;

    @RequestMapping("/teachers")
    public List<Teacher> showTeachers() throws SQLException {
        return teacherService.getAll();
    }
}
