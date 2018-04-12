package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.Diploma;
import per.coursework.university.service.diploma.DiplomaServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DiplomaController {
    @Autowired
    private DiplomaServiceImpl diplomaService;

    @RequestMapping("/diplomas")
    List<Diploma> showDiplomas() throws SQLException {
        return diplomaService.getAll();
    }
}
