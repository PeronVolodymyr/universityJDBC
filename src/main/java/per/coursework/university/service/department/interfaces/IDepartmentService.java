package per.coursework.university.service.department.interfaces;

import per.coursework.university.model.Department;

import java.sql.SQLException;
import java.util.List;

public interface IDepartmentService {

    public Department insertDepartment(Department department) throws SQLException;
    public Department getDepartment(int id) throws SQLException;
    public Department updateDepartment(Department department) throws SQLException;
    public void deleteDepartment(int id) throws SQLException;
    public List<Department> getAll() throws SQLException;
}
