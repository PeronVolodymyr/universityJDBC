package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/diploma/insert")
    Diploma insertDiploma(@RequestBody Diploma diploma) throws SQLException {
        return diplomaService.insertDiploma(diploma);
    }

    @GetMapping("/diploma/delete")
    void deleteDiploma(@RequestParam("id") int id) throws SQLException {
        diplomaService.deleteDiploma(id);
    }

    @GetMapping("/diploma/get")
    Diploma getDiplomaById(@RequestParam("id") int id) throws SQLException {
        return diplomaService.getDiploma(id);
    }

    @RequestMapping("/diploma/update")
    Diploma updateDiploma(@RequestBody Diploma diploma, @RequestParam("id") int id) throws SQLException {
        diploma.setId(id);
        return diplomaService.updateDiploma(diploma);
    }

}
