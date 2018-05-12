package per.coursework.university.service.group.interfaces;

import per.coursework.university.model.Group;

import java.sql.SQLException;
import java.util.List;

public interface IGroupService {

    public Group insertGroup(Group group) throws SQLException;
    public Group getGroup(int id) throws SQLException;
    public Group updateGroup(Group group) throws SQLException;
    public void deleteGroup(int id) throws SQLException;
    public List<Group> getAll() throws SQLException;
}
