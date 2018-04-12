package per.coursework.university.DAO.session.interfaces;

import per.coursework.university.model.Group;
import per.coursework.university.model.Session;

import java.sql.SQLException;
import java.util.List;

public interface ISessionDAO {

    public Session insertSession(Session session);
    public Session getSession(int id);
    public Session updateSession(Session session);
    public Session deleteSession(int id);
    public List<Session> getAll() throws SQLException;
}
