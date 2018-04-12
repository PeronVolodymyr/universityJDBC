package per.coursework.university.DAO.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.department.interfaces.IDepartmentDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.Deanery;
import per.coursework.university.model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentDAOJDBCImpl implements IDepartmentDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Department> list = new ArrayList<>();

    @Override
    public Department insertDepartment(Department department) {
        return null;
    }

    @Override
    public Department getDepartment(int id) {
        return null;
    }

    @Override
    public Department updateDepartment(Department department) {
        return null;
    }

    @Override
    public Department deleteDepartment(int id) {
        return null;
    }

    @Override
    public List<Department> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM department JOIN deanery " +
                "ON department.deanery_id = deanery.id");
        while (rs.next())
        {
            list.add(new Department(
                    rs.getInt("department.id"),
                    rs.getString("department.name"),
                    rs.getString("department.dean"),
                    new Deanery(rs.getInt("deanery.id"),
                            rs.getString("deanery.address"),
                            rs.getString("deanery.phone_number"))
            ));
        }
        return list;
    }
}
