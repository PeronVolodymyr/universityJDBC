package per.coursework.university.DAO.student.interfaces;

import per.coursework.university.model.Session;
import per.coursework.university.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {

    public Student insertStudent(Student student);
    public Student getStudent(int id);
    public Student updateStudent(Student student);
    public Student deleteStudent(int id);
    public List<Student> getAll() throws SQLException;
}
