package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/doctoral dissertation/insert")
    DoctoralDissertation insertDoctoralDissertation(@RequestBody DoctoralDissertation doctoralDissertation) throws SQLException {
        return doctoralDissertationService.insertDoctoralDissertation(doctoralDissertation);
    }

    @GetMapping("/doctoral dissertation/delete")
    void deleteDoctoralDissertation(@RequestParam("id") int id) throws SQLException {
        doctoralDissertationService.deleteDoctoralDissertation(id);
    }

    @GetMapping("/doctoral dissertation/get")
    DoctoralDissertation getDoctoralDissertationById(@RequestParam("id") int id) throws SQLException {
        return doctoralDissertationService.getDoctoralDissertation(id);
    }

    @RequestMapping("/doctoral dissertation/update")
    DoctoralDissertation updateDoctoralDissertation(@RequestBody DoctoralDissertation doctoralDissertation, @RequestParam("id") int id) throws SQLException {
        doctoralDissertation.setId(id);
        return doctoralDissertationService.updateDoctoralDissertation(doctoralDissertation);
    }
}
