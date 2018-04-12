package per.coursework.university.DAO.subject.interfaces;

import per.coursework.university.model.Student;
import per.coursework.university.model.Subject;

import java.sql.SQLException;
import java.util.List;

public interface ISubjectDAO {

    public Subject insertSubject(Subject subject);
    public Subject getSubject(int id);
    public Subject updateSubject(Subject subject);
    public Subject deleteSubject(int id);
    public List<Subject> getAll() throws SQLException;
}
