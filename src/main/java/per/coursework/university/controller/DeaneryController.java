package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.coursework.university.model.Deanery;
import per.coursework.university.service.deanery.DeaneryServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DeaneryController {

    @Autowired
    private DeaneryServiceImpl deaneryService;

    @RequestMapping("/deaneries")
    public List<Deanery> showDeaneries() throws SQLException {
        return deaneryService.getAll();
    }

    @PostMapping("/deanery/insert")
    Deanery insertDeanery(@RequestBody Deanery deanery) throws SQLException {
        return deaneryService.insertDeanery(deanery);
    }

    @GetMapping("/deanery/delete")
    void deleteDeanery(@RequestParam("id") int id) throws SQLException {
        deaneryService.deleteDeanery(id);
    }

    @RequestMapping("/deanery/update")
    Deanery updateDeanery(@RequestBody Deanery deanery, @RequestParam("id") int id) throws SQLException {
        deanery.setId(id);
        return deaneryService.updateDeanery(deanery);
    }

    @GetMapping("/deanery/get")
    Deanery getDeaneryById(@RequestParam("id") int id) throws SQLException {
        return deaneryService.getDeanery(id);
    }
}
