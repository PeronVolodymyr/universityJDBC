package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.Chair;
import per.coursework.university.service.chair.ChairServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ChairController {
    @Autowired
    private ChairServiceImpl chairService;
    @RequestMapping("/chairs")
    List<Chair> showChairs() throws SQLException {
        return chairService.getAll();
    }
}
