package per.coursework.university.service.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.subject.SubjectDAOJDBCImpl;
import per.coursework.university.model.Subject;
import per.coursework.university.service.subject.interfaces.ISubjectService;

import java.sql.SQLException;
import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private SubjectDAOJDBCImpl subjectDAO;

    @Override
    public Subject insertSubject(Subject subject) throws SQLException {

        return subjectDAO.insertSubject(subject);
    }

    @Override
    public Subject getSubject(int id) throws SQLException {
        return subjectDAO.getSubject(id);
    }

    @Override
    public Subject updateSubject(Subject subject) throws SQLException {
        return subjectDAO.updateSubject(subject);
    }

    @Override
    public void deleteSubject(int id) throws SQLException {
        subjectDAO.deleteSubject(id);
    }

    @Override
    public List<Subject> getAll() throws SQLException {
        return subjectDAO.getAll();
    }
}
