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
    public Student insertStudent(Student student) {
        return null;
    }

    @Override
    public Student getStudent(int id) {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public Student deleteStudent(int id) {
        return null;
    }

    @Override
    public List<Student> getAll() throws SQLException {
        return studentDAO.getAll();

    }
}
