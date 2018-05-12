package per.coursework.university.service.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.group.GroupDAOJDBCImpl;
import per.coursework.university.model.Group;
import per.coursework.university.service.group.interfaces.IGroupService;

import java.sql.SQLException;
import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    private GroupDAOJDBCImpl groupDAO;

    @Override
    public Group insertGroup(Group group) throws SQLException {

        return groupDAO.insertGroup(group);
    }

    @Override
    public Group getGroup(int id) throws SQLException {
        return groupDAO.getGroup(id);
    }

    @Override
    public Group updateGroup(Group group) throws SQLException {
        return groupDAO.updateGroup(group);
    }

    @Override
    public void deleteGroup(int id) throws SQLException {
        groupDAO.deleteGroup(id);
    }

    @Override
    public List<Group> getAll() throws SQLException {
        return groupDAO.getAll();
    }
}
