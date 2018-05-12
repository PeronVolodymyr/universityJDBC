package per.coursework.university.service.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.coursework.university.DAO.teacher.TeacherDAOJDBCImpl;
import per.coursework.university.model.Teacher;
import per.coursework.university.service.teacher.interfaces.ITeacherService;

import java.sql.SQLException;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherDAOJDBCImpl teacherDAO;

    @Override
    public Teacher insertTeacher(Teacher teacher) throws SQLException {
        return teacherDAO.insertTeacher(teacher);
    }

    @Override
    public Teacher getTeacher(int id) throws SQLException {
        return teacherDAO.getTeacher(id);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) throws SQLException {
        return teacherDAO.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(int id) throws SQLException {
        teacherDAO.deleteTeacher(id);
    }

    @Override
    public List<Teacher> getAll() throws SQLException {
        return teacherDAO.getAll();
    }
}
