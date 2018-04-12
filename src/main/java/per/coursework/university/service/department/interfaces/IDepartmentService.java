package per.coursework.university.service.department.interfaces;

import per.coursework.university.model.Department;

import java.sql.SQLException;
import java.util.List;

public interface IDepartmentService {

    public Department insertDepartment(Department department);
    public Department getDepartment(int id);
    public Department updateDepartment(Department department);
    public Department deleteDepartment(int id);
    public List<Department> getAll() throws SQLException;
}
