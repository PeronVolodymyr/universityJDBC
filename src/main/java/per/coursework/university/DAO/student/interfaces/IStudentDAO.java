package per.coursework.university.DAO.student.interfaces;

import per.coursework.university.model.Session;
import per.coursework.university.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {

    public Student insertStudent(Student student) throws SQLException;
    public Student getStudent(int id) throws SQLException;
    public Student updateStudent(Student student) throws SQLException;
    public void deleteStudent(int id) throws SQLException;
    public List<Student> getAll() throws SQLException;
}
