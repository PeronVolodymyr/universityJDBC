package per.coursework.university.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.student.StudentDAOJDBCImpl;
import per.coursework.university.model.Student;
import per.coursework.university.service.student.interfaces.IStudentService;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentDAOJDBCImpl studentDAO;

    @Override
    public Student insertStudent(Student student) throws SQLException {

        return studentDAO.insertStudent(student);
    }

    @Override
    public Student getStudent(int id) throws SQLException {
        return studentDAO.getStudent(id);
    }

    @Override
    public Student updateStudent(Student student) throws SQLException {
        return studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) throws SQLException {
        studentDAO.deleteStudent(id);
    }

    @Override
    public List<Student> getAll() throws SQLException {
        return studentDAO.getAll();
    }
}
