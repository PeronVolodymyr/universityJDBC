package per.coursework.university.DAO.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.coursework.university.DAO.student.interfaces.IStudentDAO;
import per.coursework.university.datastorage.DataStorageJDBC;
import per.coursework.university.model.*;

import java.sql.PreparedStatement;
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
    public Student insertStudent(Student student) throws SQLException {
        String query = "INSERT INTO `newdb`.`student` (`name`, `date_of_birth`, `children`, `scholarship`, `group_id`) VALUES (?,?,?,?,?)";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, student.getName());
        statement.setDate(2, java.sql.Date.valueOf(student.getDateOfBirth()));
        statement.setBoolean(3, student.isChildren());
        statement.setInt(4, student.getScholarship());
        statement.setInt(5, student.getGroup().getId());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return student;
    }

    @Override
    public Student getStudent(int id) throws SQLException {
        String query = "SELECT * FROM `newdb`.`student` " +
                "INNER JOIN newdb.group ON group_id = newdb.group.id " +
                "INNER JOIN chair ON chair_id = chair.id " +
                "INNER JOIN department ON department_id = department.id " +
                "INNER JOIN deanery ON deanery_id = deanery.id WHERE student.id=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        Student student = new Student(
                rs.getInt("student.id"),
                rs.getString("student.name"),
                rs.getDate("student.date_of_birth").toLocalDate(),
                rs.getBoolean("student.children"),
                rs.getInt("student.scholarship"),
                new Group(
                        rs.getInt("group.id"),
                        rs.getInt("group.course"),
                        rs.getInt("group.number"),
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
                )
        );
        statement.close();
        return student;
    }

    @Override
    public Student updateStudent(Student student) throws SQLException {
        String query = "UPDATE `newdb`.`student` SET `name`=?, `date_of_birth`=?, `children`=?, `scholarship`=?, `group_id`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setString(1, student.getName());
        statement.setDate(2, java.sql.Date.valueOf(student.getDateOfBirth()));
        statement.setBoolean(3, student.isChildren());
        statement.setInt(4, student.getScholarship());
        statement.setInt(5, student.getGroup().getId());
        statement.setInt(6, student.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return student;
    }

    @Override
    public void deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM `newdb`.`student` WHERE `id`=?";
        PreparedStatement statement = dataStorage.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        int countDeletedRows = statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<Student> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM student " +
                "INNER JOIN newdb.group ON group_id = newdb.group.id " +
                "INNER JOIN chair ON chair_id = chair.id " +
                "INNER JOIN department ON department_id = department.id " +
                "INNER JOIN deanery ON deanery_id = deanery.id " +
                "order by student.id");
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
                    )
            ));
        }
        return list;
    }
}
