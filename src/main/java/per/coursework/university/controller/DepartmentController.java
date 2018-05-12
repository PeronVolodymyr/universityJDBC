package per.coursework.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/department/insert")
    Department insertDepartment(@RequestBody Department department) throws SQLException {
        return departmentService.insertDepartment(department);
    }

    @GetMapping("/department/delete")
    void deleteDepartment(@RequestParam("id") int id) throws SQLException {
        departmentService.deleteDepartment(id);
    }

    @GetMapping("/department/get")
    Department getDepartmentById(@RequestParam("id") int id) throws SQLException {
        return departmentService.getDepartment(id);
    }

    @RequestMapping("/department/update")
    Department updateDepartment(@RequestBody Department department, @RequestParam("id") int id) throws SQLException {
        department.setId(id);
        return departmentService.updateDepartment(department);
    }
}
