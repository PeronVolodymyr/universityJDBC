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
    public Teacher insertTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Teacher getTeacher(int id) {
        return null;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Teacher deleteTeacher(int id) {
        return null;
    }

    @Override
    public List<Teacher> getAll() throws SQLException {
        return teacherDAO.getAll();
    }
}
