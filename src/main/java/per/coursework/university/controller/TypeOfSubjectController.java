package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.TypeOfSubject;
import per.coursework.university.service.typeOfSubject.TypeOfSubjectServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfSubjectController {
    @Autowired
    private TypeOfSubjectServiceImpl typeOfSubjectService;

    @RequestMapping("/types of subject")
    List<TypeOfSubject> showTypesOfSubject() throws SQLException {
        return typeOfSubjectService.getAll();
    }
}
