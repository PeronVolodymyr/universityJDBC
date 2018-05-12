package per.coursework.university.service.subject.interfaces;

import per.coursework.university.model.Subject;

import java.sql.SQLException;
import java.util.List;

public interface ISubjectService {

    public Subject insertSubject(Subject subject) throws SQLException;
    public Subject getSubject(int id) throws SQLException;
    public Subject updateSubject(Subject subject) throws SQLException;
    public void deleteSubject(int id) throws SQLException;
    public List<Subject> getAll() throws SQLException;
}
