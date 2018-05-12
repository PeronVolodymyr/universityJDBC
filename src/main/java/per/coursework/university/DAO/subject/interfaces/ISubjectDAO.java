package per.coursework.university.DAO.subject.interfaces;

import per.coursework.university.model.Student;
import per.coursework.university.model.Subject;

import java.sql.SQLException;
import java.util.List;

public interface ISubjectDAO {

    public Subject insertSubject(Subject subject) throws SQLException;
    public Subject getSubject(int id) throws SQLException;
    public Subject updateSubject(Subject subject) throws SQLException;
    public void deleteSubject(int id) throws SQLException;
    public List<Subject> getAll() throws SQLException;
}
