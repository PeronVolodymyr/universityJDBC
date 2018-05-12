package per.coursework.university.service.session.interfaces;

import per.coursework.university.model.Session;

import java.sql.SQLException;
import java.util.List;

public interface ISessionService {

    public Session insertSession(Session session) throws SQLException;
    public Session getSession(int id) throws SQLException;
    public Session updateSession(Session session) throws SQLException;
    public void deleteSession(int id) throws SQLException;
    public List<Session> getAll() throws SQLException;
}
