package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.DAO.deanery.DeaneryDAOJDBCImpl;
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
}
