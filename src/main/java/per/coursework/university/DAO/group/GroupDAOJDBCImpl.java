package per.coursework.university.DAO.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.group.interfaces.IGroupDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.Chair;
import per.coursework.university.model.Deanery;
import per.coursework.university.model.Department;
import per.coursework.university.model.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GroupDAOJDBCImpl implements IGroupDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Group> list = new ArrayList<>();

    @Override
    public Group insertGroup(Group group) throws SQLException {
        String query = "INSERT INTO `newdb`.`group` (`number`, `course`, `chair_id`) VALUES (?,?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1, group.getNumber());
        statement.setInt(2, group.getCourse());
        statement.setInt(3, group.getChair().getId());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return group;
    }

    @Override
    public Group getGroup(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`group` " +
                "INNER JOIN chair ON chair_id = chair.id " +
                "INNER JOIN department ON department_id = department.id " +
                "INNER JOIN deanery ON deanery_id = deanery.id WHERE newdb.group.id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        Group group = new Group(
                rs.getInt("group.id"),
                rs.getInt("group.course"),
                rs.getInt("group.number"),
                new Chair(
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
                )
        );
        statement.close();
        return group;
    }

    @Override
    public Group updateGroup(Group group) throws SQLException {
        String query = "UPDATE `newdb`.`group` SET `number`=?, `course`=?, `chair_id`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,group.getNumber());
        statement.setInt(2,group.getCourse());
        statement.setInt(3,group.getChair().getId());
        statement.setInt(4,group.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return group;
    }

    @Override
    public void deleteGroup(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`group` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<Group> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM newdb.group " +
                "INNER JOIN chair ON chair_id = chair.id " +
                "INNER JOIN department ON department_id = department.id " +
                "INNER JOIN deanery ON deanery_id = deanery.id order by newdb.group.id");
        while (rs.next())
        {
            list.add(new Group(
                    rs.getInt("group.id"),
                    rs.getInt("group.course"),
                    rs.getInt("group.number"),
                    new Chair(
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
                    )
            ));
        }
        return list;
    }
}
