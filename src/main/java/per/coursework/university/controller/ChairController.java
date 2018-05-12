package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/chair/insert")
    Chair insertChair(@RequestBody Chair chair) throws SQLException {
        return chairService.insertChair(chair);
    }

    @GetMapping("/chair/delete")
    void deleteChair(@RequestParam("id") int id) throws SQLException {
        chairService.deleteChair(id);
    }

    @GetMapping("/chair/get")
    Chair getChairById(@RequestParam("id") int id) throws SQLException {
        return chairService.getChair(id);
    }

    @RequestMapping("/chair/update")
    Chair updateChair(@RequestBody Chair chair, @RequestParam("id") int id) throws SQLException {
        chair.setId(id);
        return chairService.updateChair(chair);
    }
}
