package per.coursework.university.DAO.chair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.chair.interfaces.IChairDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.Chair;
import per.coursework.university.model.Deanery;
import per.coursework.university.model.Department;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChairDAOJDBCImpl implements IChairDAO {

    //do not work----------------------------------------
    //to be continued---------------------------------------
    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Chair> list = new ArrayList<>();

    @Override
    public Chair insertChair(Chair chair) throws SQLException {
        String query = "INSERT INTO `newdb`.`chair` (`name`, `head_of_chair`, `department_id`) VALUES (?,?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1,chair.getName());
        statement.setString(2,chair.getHeadOfChair());
        statement.setInt(3,chair.getDepartment().getId());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return chair;
    }

    @Override
    public Chair getChair(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`chair` " +
                "INNER JOIN department ON department_id = department.id " +
                "INNER JOIN deanery ON deanery_id = deanery.id WHERE chair.id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        Chair chair = new Chair(
                rs.getInt("chair.id"),
                rs.getString("chair.name"),
                rs.getString("chair.head_of_chair"),
                new Department(
                        rs.getInt("department.id"),
                        rs.getString("department.name"),
                        rs.getString("department.dean"),
                        new Deanery(
                                rs.getInt("deanery.id"),
                                rs.getString("deanery.address"),
                                rs.getString("deanery.phone_number"))
                ));
        statement.close();
        return chair;
    }

    @Override
    public Chair updateChair(Chair chair) throws SQLException {
        String query = "UPDATE `newdb`.`chair` SET `name`=?, `head_of_chair`=?, `department_id`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1,chair.getName());
        statement.setString(2,chair.getHeadOfChair());
        statement.setInt(3,chair.getDepartment().getId());
        statement.setInt(4,chair.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return chair;
    }

    @Override
    public void deleteChair(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`chair` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<Chair> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM chair " +
                "INNER JOIN department ON department_id = department.id " +
                "INNER JOIN deanery ON deanery_id = deanery.id");
        while (rs.next())
        {
            list.add(new Chair(
                    rs.getInt("chair.id"),
                    rs.getString("chair.name"),
                    rs.getString("chair.head_of_chair"),
                    new Department(
                            rs.getInt("department.id"),
                            rs.getString("department.name"),
                            rs.getString("department.dean"),
                            new Deanery(rs.getInt("deanery.id"),
                                    rs.getString("deanery.address"),
                                    rs.getString("deanery.phone_number"))
                    )
            ));
        }
        return list;
    }
}
