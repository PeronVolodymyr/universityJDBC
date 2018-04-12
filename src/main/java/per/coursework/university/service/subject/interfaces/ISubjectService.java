package per.coursework.university.service.subject.interfaces;

import per.coursework.university.model.Subject;

import java.sql.SQLException;
import java.util.List;

public interface ISubjectService {

    public Subject insertSubject(Subject subject);
    public Subject getSubject(int id);
    public Subject updateSubject(Subject subject);
    public Subject deleteSubject(int id);
    public List<Subject> getAll() throws SQLException;
}
