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
    public Subject insertSubject(Subject subject) {
        return null;
    }

    @Override
    public Subject getSubject(int id) {
        return null;
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return null;
    }

    @Override
    public Subject deleteSubject(int id) {
        return null;
    }

    @Override
    public List<Subject> getAll() throws SQLException {
        return subjectDAO.getAll();
    }
}
