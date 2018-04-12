package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.coursework.university.model.Department;
import per.coursework.university.service.department.DepartmentServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @RequestMapping("/departments")
    public List<Department> showDepartments() throws SQLException {
        return departmentService.getAll();
    }
}
