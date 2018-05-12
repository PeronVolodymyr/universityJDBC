package per.coursework.university.DAO.deanery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.deanery.interfaces.IDeaneryDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.CategoryOfTeacher;
import per.coursework.university.model.Deanery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeaneryDAOJDBCImpl implements IDeaneryDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Deanery> list = new ArrayList<>();

    @Override
    public Deanery insertDeanery(Deanery deanery) throws SQLException {
        String query = "INSERT INTO `newdb`.`deanery` (`address`, `phone_number`) VALUES (?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1,deanery.getAddress());
        statement.setString(2,deanery.getPhoneNumber());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return deanery;
    }

    @Override
    public Deanery getDeanery(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`deanery` WHERE id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        Deanery deanery = new Deanery(
                rs.getInt("id"),
                rs.getString("address"),
                rs.getString("phone_number"));
        statement.close();
        return deanery;
    }

    @Override
    public Deanery updateDeanery(Deanery deanery) throws SQLException {
        String query = "UPDATE `newdb`.`deanery` SET `phone_number`=?, `address`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1,deanery.getPhoneNumber());
        statement.setString(2,deanery.getAddress());
        statement.setInt(3,deanery.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return deanery;
    }

    @Override
    public void deleteDeanery(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`deanery` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<Deanery> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM deanery");
        while (rs.next())
        {
            list.add(new Deanery(
                    rs.getInt("id"),
                    rs.getString("address"),
                    rs.getString("phone_number")
            ));
        }
        return list;
    }
}
