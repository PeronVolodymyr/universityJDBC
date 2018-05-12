package per.coursework.university.DAO.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.teacher.interfaces.ITeacherDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.*;

import java.sql.PreparedStatement;
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
    public Teacher insertTeacher(Teacher teacher) throws SQLException {
        String query = "INSERT INTO `newdb`.`teacher` (`name`, `date_of_birth`, `count_of_children`, `salary`, `category_of_teacher_id`, `chair_id`) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, teacher.getName());
        statement.setDate(2, java.sql.Date.valueOf(teacher.getDateOfBirth()));
        statement.setInt(3, teacher.getCountOfChildren());
        statement.setInt(4, teacher.getSalary());
        statement.setInt(5, teacher.getCategoryOfTeacher().getId());
        statement.setInt(6, teacher.getChair().getId());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return teacher;
    }

    @Override
    public Teacher getTeacher(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`teacher` " +
                "INNER JOIN category_of_teacher ON category_of_teacher_id = category_of_teacher.id " +
                "INNER JOIN chair ON chair_id = chair.id " +
                "INNER JOIN department ON department_id = department.id " +
                "INNER JOIN deanery ON deanery_id = deanery.id WHERE teacher.id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        Teacher teacher = new Teacher(
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
                        new Department(
                                rs.getInt("department.id"),
                                rs.getString("department.name"),
                                rs.getString("department.dean"),
                                new Deanery(rs.getInt("deanery.id"),
                                        rs.getString("deanery.address"),
                                        rs.getString("deanery.phone_number"))
                        )
                )
        );
        statement.close();
        return teacher;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) throws SQLException {
        String query = "UPDATE `newdb`.`teacher` SET `name`=?, `date_of_birth`=?, `count_of_children`=?, `salary`=?, `category_of_teacher_id`=?, `chair_id`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, teacher.getName());
        statement.setDate(2, java.sql.Date.valueOf(teacher.getDateOfBirth()));
        statement.setInt(3, teacher.getCountOfChildren());
        statement.setInt(4, teacher.getSalary());
        statement.setInt(5, teacher.getCategoryOfTeacher().getId());
        statement.setInt(6, teacher.getChair().getId());
        statement.setInt(7, teacher.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return teacher;
    }

    @Override
    public void deleteTeacher(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`teacher` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<Teacher> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("select * from teacher " +
                "inner join category_of_teacher on category_of_teacher_id = category_of_teacher.id " +
                "inner join chair on chair_id = chair.id " +
                "inner join department on department_id = department.id " +
                "inner join deanery on deanery_id = deanery.id " +
                "order by teacher.id");
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
                            new Department(
                                    rs.getInt("department.id"),
                                    rs.getString("department.name"),
                                    rs.getString("department.dean"),
                                    new Deanery(rs.getInt("deanery.id"),
                                            rs.getString("deanery.address"),
                                            rs.getString("deanery.phone_number"))
                            )
                    )
            ));
        }
        return list;
    }
}
