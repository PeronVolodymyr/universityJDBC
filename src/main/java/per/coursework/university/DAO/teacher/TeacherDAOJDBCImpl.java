package per.coursework.university.DAO.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.teacher.interfaces.ITeacherDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.CategoryOfTeacher;
import per.coursework.university.model.Chair;
import per.coursework.university.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherDAOJDBCImpl implements ITeacherDAO {

    @Autowired
    private DataStorageJDBC dataStorage;

    private List<Teacher> list = new ArrayList<>();

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
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from teacher inner join chair" +
                " on chair_id = chair.id inner join category_of_teacher on " +
                "category_of_teacher_id = category_of_teacher.id");
        while (rs.next()){
            list.add(new Teacher(
                    rs.getInt("teacher.id"),
                    rs.getString("teacher.name"),
                    rs.getDate("teacher.date_of_birth").toLocalDate(),
                    rs.getInt("teacher.count_of_children"),
                    rs.getInt("teacher.salary"),
                    new CategoryOfTeacher(
                            rs.getInt("category_of_teacher.id"),
                            rs.getString("category_of_teacher.category")),
                    new Chair(
                            rs.getInt("chair.id"),
                            rs.getString("chair.name"),
                            rs.getString("chair.head_of_chair"),
                            null
                    )
            ));
        }
        return list;
    }
}
