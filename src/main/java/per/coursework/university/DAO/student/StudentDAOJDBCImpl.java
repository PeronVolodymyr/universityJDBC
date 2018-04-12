package per.coursework.university.DAO.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.student.interfaces.IStudentDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.Group;
import per.coursework.university.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAOJDBCImpl implements IStudentDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Student> list = new ArrayList<>();

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
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM student INNER JOIN " +
                "information_system_of_the_university.group " +
                "ON group_id = information_system_of_the_university.group.id");
        while (rs.next())
        {
            list.add(new Student(
                    rs.getInt("student.id"),
                    rs.getString("student.name"),
                    rs.getDate("student.date_of_birth").toLocalDate(),
                    rs.getBoolean("student.children"),
                    rs.getInt("student.scholarship"),
                    new Group(
                            rs.getInt("group.id"),
                            rs.getInt("group.course"),
                            rs.getInt("group.number"),
                            null
                    )
            ));
        }
        return list;
    }
}
