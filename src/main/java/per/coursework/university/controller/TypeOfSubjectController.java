package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/type of subject/insert")
    TypeOfSubject insertOneTypeOfSubject(@RequestBody TypeOfSubject typeOfSubject) throws SQLException {
        return typeOfSubjectService.insertTypeOfSubject(typeOfSubject);
    }

    @GetMapping("/type of subject/delete")
    void deleteTypeOfSubjectById(@RequestParam("id") int id) throws SQLException {
        typeOfSubjectService.deleteTypeOfSubject(id);
    }

    @RequestMapping("/type of subject/update")
    TypeOfSubject updateTypeOfSubject(@RequestBody TypeOfSubject typeOfSubject, @RequestParam("id") int id) throws SQLException {
        typeOfSubject.setId(id);
        return typeOfSubjectService.updateTypeOfSubject(typeOfSubject);
    }

    @GetMapping("/type of subject/get")
    TypeOfSubject getTypeOfSubjectById(@RequestParam("id") int id) throws SQLException {
        return typeOfSubjectService.getTypeOfSubject(id);
    }
}
