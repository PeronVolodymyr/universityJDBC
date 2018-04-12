package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.CategoryOfTeacher;
import per.coursework.university.service.categoryOfTeacher.CategoryOfTeacherServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryOfTeacherController {
    @Autowired
    private CategoryOfTeacherServiceImpl categoryOfTeacherService;

    @RequestMapping("/categories of teacher")
    List<CategoryOfTeacher> showCategoriesOfTeacher() throws SQLException {
        return categoryOfTeacherService.getAll();
    }

}
