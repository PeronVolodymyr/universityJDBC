package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
