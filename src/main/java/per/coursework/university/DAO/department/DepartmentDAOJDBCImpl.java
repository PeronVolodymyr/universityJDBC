package per.coursework.university.DAO.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.department.interfaces.IDepartmentDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.Deanery;
import per.coursework.university.model.Department;

import java.sql.PreparedStatement;
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
    public Department insertDepartment(Department department) throws SQLException {
        String query = "INSERT INTO `newdb`.`department` (`name`, `dean`, `deanery_id`) VALUES (?,?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1,department.getName());
        statement.setString(2,department.getDean());
        statement.setInt(3,department.getDeanery().getId());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return department;
    }

    @Override
    public Department getDepartment(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`department` " +
                "JOIN deanery ON deanery_id = deanery.id WHERE department.id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        Department department = new Department(
                rs.getInt("department.id"),
                rs.getString("department.name"),
                rs.getString("department.dean"),
                new Deanery(rs.getInt("deanery.id"),
                        rs.getString("deanery.address"),
                        rs.getString("deanery.phone_number"))
        );
        statement.close();
        return department;
    }

    @Override
    public Department updateDepartment(Department department) throws SQLException {
        String query = "UPDATE `newdb`.`department` SET `name`=?, `dean`=?, `deanery_id`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1,department.getName());
        statement.setString(2,department.getDean());
        statement.setInt(3,department.getDeanery().getId());
        statement.setInt(4,department.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return department;
    }

    @Override
    public void deleteDepartment(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`department` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
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
