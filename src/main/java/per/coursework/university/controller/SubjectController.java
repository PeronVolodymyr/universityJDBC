package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.Subject;
import per.coursework.university.service.subject.SubjectServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    @Autowired
    private SubjectServiceImpl subjectService;

    @RequestMapping("/subjects")
    public List<Subject> showSubjects() throws SQLException {
        return subjectService.getAll();
    }
}
