package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/subject/insert")
    Subject insertSubject(@RequestBody Subject subject) throws SQLException {
        return subjectService.insertSubject(subject);
    }

    @GetMapping("/subject/delete")
    void deleteSubject(@RequestParam("id") int id) throws SQLException {
        subjectService.deleteSubject(id);
    }

    @GetMapping("/subject/get")
    Subject getSubjectById(@RequestParam("id") int id) throws SQLException {
        return subjectService.getSubject(id);
    }

    @RequestMapping("/subject/update")
    Subject updateSubject(@RequestBody Subject subject, @RequestParam("id") int id) throws SQLException {
        subject.setId(id);
        return subjectService.updateSubject(subject);
    }
}
