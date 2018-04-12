package per.coursework.university.DAO.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.group.interfaces.IGroupDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.Chair;
import per.coursework.university.model.Group;

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
    public Group insertGroup(Group group) {
        return null;
    }

    @Override
    public Group getGroup(int id) {
        return null;
    }

    @Override
    public Group updateGroup(Group group) {
        return null;
    }

    @Override
    public Group deleteGroup(int id) {
        return null;
    }

    @Override
    public List<Group> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM information_system_of_the_university.group INNER JOIN chair " +
                "ON chair_id = chair.id");
        while (rs.next())
        {
            list.add(new Group(
                    rs.getInt("group.id"),
                    rs.getInt("group.number"),
                    rs.getInt("group.course"),
                    new Chair(
                            rs.getInt("chair.id"),
                            rs.getString("chair.name"),
                            rs.getString("chair.head_of_chair"),
                            null
                    )
            ));
        }
        return list;
    }
}
