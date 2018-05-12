package per.coursework.university.service.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.session.SessionDAOJDBCImpl;
import per.coursework.university.model.Session;
import per.coursework.university.service.session.interfaces.ISessionService;

import java.sql.SQLException;
import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService {

    @Autowired
    private SessionDAOJDBCImpl sessionDAO;

    @Override
    public Session insertSession(Session session) throws SQLException {
        return sessionDAO.insertSession(session);
    }

    @Override
    public Session getSession(int id) throws SQLException {
        return sessionDAO.getSession(id);
    }

    @Override
    public Session updateSession(Session session) throws SQLException {
        return sessionDAO.updateSession(session);
    }

    @Override
    public void deleteSession(int id) throws SQLException {
        sessionDAO.deleteSession(id);
    }

    @Override
    public List<Session> getAll() throws SQLException {
        return sessionDAO.getAll();
    }
}
