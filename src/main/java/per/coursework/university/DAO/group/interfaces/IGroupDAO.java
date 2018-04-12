package per.coursework.university.DAO.group.interfaces;

import per.coursework.university.model.FormOfControl;
import per.coursework.university.model.Group;

import java.sql.SQLException;
import java.util.List;

public interface IGroupDAO {

    public Group insertGroup(Group group);
    public Group getGroup(int id);
    public Group updateGroup(Group group);
    public Group deleteGroup(int id);
    public List<Group> getAll() throws SQLException;
}
