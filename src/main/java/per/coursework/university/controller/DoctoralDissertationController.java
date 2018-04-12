package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.DoctoralDissertation;
import per.coursework.university.service.doctoralDissertation.DoctoralDissertationServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctoralDissertationController {
    @Autowired
    private DoctoralDissertationServiceImpl doctoralDissertationService;

    @RequestMapping("/doctoral dissertations")
    List<DoctoralDissertation> showDoctoralDissertations() throws SQLException {
        return doctoralDissertationService.getAll();
    }
}
