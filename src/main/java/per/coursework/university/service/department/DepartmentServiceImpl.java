package per.coursework.university.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.deanery.DeaneryDAOJDBCImpl;
import per.coursework.university.DAO.department.DepartmentDAOJDBCImpl;
import per.coursework.university.model.Department;
import per.coursework.university.service.department.interfaces.IDepartmentService;

import java.sql.SQLException;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentDAOJDBCImpl departmentDAO;

    @Override
    public Department insertDepartment(Department department) throws SQLException {

        return departmentDAO.insertDepartment(department);
    }

    @Override
    public Department getDepartment(int id) throws SQLException {

        return departmentDAO.getDepartment(id);
    }

    @Override
    public Department updateDepartment(Department department) throws SQLException {

        return departmentDAO.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(int id) throws SQLException {
        departmentDAO.deleteDepartment(id);
    }

    @Override
    public List<Department> getAll() throws SQLException {
        return departmentDAO.getAll();
    }
}
