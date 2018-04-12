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
        return groupDAO.getAll();
    }
}
