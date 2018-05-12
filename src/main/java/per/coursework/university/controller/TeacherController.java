package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/teacher/insert")
    Teacher insertTeacher(@RequestBody Teacher teacher) throws SQLException {
        return teacherService.insertTeacher(teacher);
    }

    @GetMapping("/teacher/delete")
    void deleteTeacher(@RequestParam("id") int id) throws SQLException {
        teacherService.deleteTeacher(id);
    }

    @GetMapping("/teacher/get")
    Teacher getTeacherById(@RequestParam("id") int id) throws SQLException {
        return teacherService.getTeacher(id);
    }

    @RequestMapping("/teacher/update")
    Teacher updateTeacher(@RequestBody Teacher teacher, @RequestParam("id") int id) throws SQLException {
        teacher.setId(id);
        return teacherService.updateTeacher(teacher);
    }
}
