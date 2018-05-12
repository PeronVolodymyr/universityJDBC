package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.coursework.university.model.Curriculum;
import per.coursework.university.service.curriculum.CurriculumServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CurriculumController {
    @Autowired
    private CurriculumServiceImpl curriculumService;

    @RequestMapping("curriculum")
    public List<Curriculum> showCurriculum() throws SQLException {
        return curriculumService.getAll();
    }

    @PostMapping("/curriculum/insert")
    Curriculum insertCurriculum(@RequestBody Curriculum curriculum) throws SQLException {
        return curriculumService.insertCurriculum(curriculum);
    }

    @GetMapping("/curriculum/delete")
    void deleteCurriculum(@RequestParam("id") int id) throws SQLException {
        curriculumService.deleteCurriculum(id);
    }

    @GetMapping("/curriculum/get")
    Curriculum getCurriculumById(@RequestParam("id") int id) throws SQLException {
        return curriculumService.getCurriculum(id);
    }

    @RequestMapping("/curriculum/update")
    Curriculum updateCurriculum(@RequestBody Curriculum curriculum, @RequestParam("id") int id) throws SQLException {
        curriculum.setId(id);
        return curriculumService.updateCurriculum(curriculum);
    }
}
