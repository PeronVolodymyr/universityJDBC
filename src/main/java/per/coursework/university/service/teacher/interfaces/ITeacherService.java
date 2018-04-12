package per.coursework.university.service.teacher.interfaces;

import per.coursework.university.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface ITeacherService {

    public Teacher insertTeacher(Teacher teacher);
    public Teacher getTeacher(int id);
    public Teacher updateTeacher(Teacher teacher);
    public Teacher deleteTeacher(int id);
    public List<Teacher> getAll() throws SQLException;
}
