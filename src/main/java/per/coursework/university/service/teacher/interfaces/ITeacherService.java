package per.coursework.university.service.teacher.interfaces;

import per.coursework.university.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface ITeacherService {

    public Teacher insertTeacher(Teacher teacher) throws SQLException;
    public Teacher getTeacher(int id) throws SQLException;
    public Teacher updateTeacher(Teacher teacher) throws SQLException;
    public void deleteTeacher(int id) throws SQLException;
    public List<Teacher> getAll() throws SQLException;
}
