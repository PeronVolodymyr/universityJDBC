package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/category of teacher/insert")
    CategoryOfTeacher insertOneCategoryOfTeacher(@RequestBody CategoryOfTeacher categoryOfTeacher) throws SQLException {
        return categoryOfTeacherService.insertCategoryOfTeacher(categoryOfTeacher);
    }

    @GetMapping("/category of teacher/delete")
    void deleteCategoryById(@RequestParam("id") int id) throws SQLException {
        categoryOfTeacherService.deleteCategoryOfTeacher(id);
    }

    @RequestMapping("/category of teacher/update")
    CategoryOfTeacher updateCategory(@RequestBody CategoryOfTeacher categoryOfTeacher, @RequestParam("id") int id) throws SQLException {
        categoryOfTeacher.setId(id);
        return categoryOfTeacherService.updateCategoryOfTeacher(categoryOfTeacher);
    }

    @GetMapping("/category of teacher/get")
    CategoryOfTeacher getCategoryOfTeacherById(@RequestParam("id") int id) throws SQLException {
        return categoryOfTeacherService.getCategoryOfTeacher(id);
    }


}
